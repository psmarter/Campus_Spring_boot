package com.example.campusitemsharing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseModel register(@RequestBody User user) {
        return userService.registerUser(user.getStudentNumber(), user.getAccount(), user.getPasswordHash(), user.getEmail());
    }

    @PostMapping("/login")
    public ResponseModel login(@RequestBody User user) {
        return userService.loginUser(user.getAccount(), user.getPasswordHash());
    }

    @PutMapping("/update")  // 使用PUT请求
    public ResponseModel updateUser(@RequestBody User user) {
        return userService.updateUserInformation(user);
    }

    @DeleteMapping("/delete/{account}") // 删除用户的请求处理
    public ResponseModel deleteUser(@PathVariable String account) {
        return userService.deleteUser(account);
    }
}