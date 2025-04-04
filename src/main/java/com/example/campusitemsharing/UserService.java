package com.example.campusitemsharing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseModel registerUser(String studentNumber, String account, String password, String email) {
        ResponseModel response = new ResponseModel();
        if (userRepository.findByAccount(account) != null) {
            response.setStatus("error");
            response.setMessage("Account already exists");
            return response;
        }

        // 创建新用户
        User user = new User();
        user.setStudentNumber(studentNumber);
        user.setAccount(account);
        user.setPasswordHash(passwordEncoder.encode(password)); // 加密密码
        user.setEmail(email);

        userRepository.save(user);

        response.setStatus("success");
        response.setMessage("Registration successful");
        return response;
    }

    public ResponseModel loginUser(String account, String password) {
        ResponseModel response = new ResponseModel();
        User user = userRepository.findByAccount(account);
        if (user == null || !passwordEncoder.matches(password, user.getPasswordHash())) {
            response.setStatus("error");
            response.setMessage("Invalid account or password");
            return response;
        }
        UserDetails userDetails = new UserDetails();
        userDetails.setStudentNumber(user.getStudentNumber());
        userDetails.setAccount(user.getAccount());
        userDetails.setPasswordHash(user.getPasswordHash());
        userDetails.setEmail(user.getEmail());

        response.setStatus("success");
        response.setMessage("Login successful");
        response.setUserDetails(userDetails);

        return response;
    }

    public ResponseModel updateUserInformation(User user) {
        ResponseModel response = new ResponseModel();

        // 查找现有用户
        User existingUser = userRepository.findByAccount(user.getAccount());
        if (existingUser == null) {
            response.setStatus("error");
            response.setMessage("User not found");
            return response;
        }

        // 更新学号
        existingUser.setStudentNumber(user.getStudentNumber());

        // 更新账户名
        existingUser.setAccount(user.getAccount());

        // 更新邮箱
        existingUser.setEmail(user.getEmail());

        // 如果新密码被提供，则更新密码
        if (user.getPasswordHash() != null && !user.getPasswordHash().isEmpty() && !user.getPasswordHash().equals(existingUser.getPasswordHash())) {
            existingUser.setPasswordHash(passwordEncoder.encode(user.getPasswordHash())); // 加密新密码
        }

        // 保存更新后的用户信息
        userRepository.save(existingUser);

        response.setStatus("success");
        response.setMessage("User information updated successfully");
        return response;
    }

    public ResponseModel deleteUser(String account) {
        ResponseModel response = new ResponseModel();
        User user = userRepository.findByAccount(account);

        if (user == null) {
            response.setStatus("error");
            response.setMessage("User not found");
            return response;
        }

        // 从数据库中删除用户
        userRepository.delete(user);

        response.setStatus("success");
        response.setMessage("User account deleted successfully");
        return response;
    }
}
