package com.example.campusitemsharing;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * 用户实体类 / User Entity Class
 * 
 * 表示系统中的用户信息，映射到数据库的 users 表。
 * Represents user information in the system, mapped to the 'users' table in the database.
 * 
 * 包含用户的基本信息，如学号、账号、密码哈希值和邮箱。
 * Contains basic user information such as student number, account, password hash, and email.
 * 
 * @author psmarter
 * @version 1.0
 * @since 2025-12-30
 */
@Entity
@Table(name = "users")
public class User {
    /**
     * 用户唯一标识符（主键）/ User unique identifier (primary key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学号（唯一且不能为空）/ Student number (unique and not null)
     */
    @Column(nullable = false, unique = true)
    private String studentNumber;

    /**
     * 账号名称（唯一且不能为空） / Account name (unique and not null)
     */
    @Column(nullable = false, unique = true)
    private String account;

    /**
     * 密码哈希值（不能为空）/ Password hash (not null)
     * 注意：不存储明文密码，仅存储加密后的哈希值
     * Note: Does not store plain text password, only encrypted hash
     */
    @Column(nullable = false)
    private String passwordHash;

    /**
     * 电子邮箱地址 / Email address
     */
    @Column
    private String email;

    /**
     * 账号创建时间（不可更新）/ Account creation time (not updatable)
     */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // ==================== Getters and Setters / 获取器和设置器 ====================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
