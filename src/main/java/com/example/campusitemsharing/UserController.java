package com.example.campusitemsharing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器类 / User Controller Class
 * 
 * 处理用户相关的 HTTP 请求，包括注册、登录、更新和删除操作。
 * Handles user-related HTTP requests including registration, login, update, and delete operations.
 * 
 * 基础路径：/api/users
 * Base path: /api/users
 * 
 * @author psmarter
 * @version 1.0
 * @since 2025-12-30
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册端点 / User registration endpoint
     * 
     * 处理新用户注册请求。
     * Handles new user registration requests.
     * 
     * @param user 用户信息对象，包含学号、账号、密码和邮箱 / User object containing student number, account, password, and email
     * @return 响应模型，包含注册结果 / Response model containing registration result
     */
    @PostMapping("/register")
    public ResponseModel register(@RequestBody User user) {
        return userService.registerUser(user.getStudentNumber(), user.getAccount(), user.getPasswordHash(), user.getEmail());
    }

    /**
     * 用户登录端点 / User login endpoint
     * 
     * 验证用户凭据并创建会话。
     * Validates user credentials and creates a session.
     * 
     * @param user 用户对象，包含账号和密码 / User object containing account and password
     * @return 响应模型，包含登录结果和用户信息 / Response model containing login result and user information
     */
    @PostMapping("/login")
    public ResponseModel login(@RequestBody User user) {
        return userService.loginUser(user.getAccount(), user.getPasswordHash());
    }

    /**
     * 更新用户信息端点 / Update user information endpoint
     * 
     * 更新现有用户的信息。
     * Updates existing user information.
     * 
     * @param user 更新后的用户对象 / Updated user object
     * @return 响应模型，包含更新结果 / Response model containing update result
     */
    @PutMapping("/update")  // 使用PUT请求 / Using PUT request
    public ResponseModel updateUser(@RequestBody User user) {
        return userService.updateUserInformation(user);
    }

    /**
     * 删除用户端点 / Delete user endpoint
     * 
     * 根据账号删除用户。
     * Deletes a user by account name.
     * 
     * @param account 要删除的用户账号 / Account name of the user to delete
     * @return 响应模型，包含删除结果 / Response model containing deletion result
     */
    @DeleteMapping("/delete/{account}") // 删除用户的请求处理 / Handle user deletion request
    public ResponseModel deleteUser(@PathVariable String account) {
        return userService.deleteUser(account);
    }
}