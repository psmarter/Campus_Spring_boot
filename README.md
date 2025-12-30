# 🎓 Campus Item Sharing Platform / 校园物品共享平台

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen?style=flat-square&logo=spring)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square&logo=mysql)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)

**A modern Spring Boot-based platform for campus item sharing, exchange, and management**

**基于 Spring Boot 的现代化校园物品共享、交换和管理平台**

[English](#english) | [中文](#中文)

</div>

---

## 🔗 相关仓库 / Related Repositories

> **本项目是 Campus Item Sharing Platform 的后端 API 服务**  
> **This is the backend API service for Campus Item Sharing Platform**

### 📦 完整项目组成 / Complete Project Components

| 组件 Component | 仓库 Repository | 技术栈 Tech Stack | 说明 Description |
|---------------|----------------|------------------|-----------------|
| **⚙️ 后端 Backend** | [Campus_Spring_boot](https://github.com/psmarter/Campus_Spring_boot) **(当前仓库)** | Spring Boot + MySQL | RESTful API Server |
| **🎨 前端 Frontend** | [CampusShare-AI](https://github.com/psmarter/CampusShare-AI) | Android (Kotlin) + Gemini AI | Mobile Application |

### 🚀 快速部署 / Quick Deployment Options

#### 🔧 仅后端开发 / Backend Only

按照下方的 [Quick Start](#quick-start) 指南即可。

#### 📱 前后端联调 / Full-Stack Development

1. ✅ 启动后端服务（本仓库，按照下方指南）
2. ✅ 克隆并配置前端仓库：[CampusShare-AI](https://github.com/psmarter/CampusShare-AI)
3. ✅ 在前端应用中配置后端 API 地址

> **💡 移动端开发者提示 / Mobile Developer Tip**:  
> 如果使用 Android 模拟器调试，后端地址应配置为 `http://10.0.2.2:8080`  
> If using Android emulator, configure backend URL as `http://10.0.2.2:8080`

---

## English

### 📖 Overview

Campus Item Sharing Platform is a full-stack web application designed to help university students share, exchange, and manage items within their campus community. Built with Spring Boot and modern Java technologies, it provides a secure and efficient way for students to connect and share resources.

### ✨ Features

- 🔐 **User Authentication & Authorization**
  - Secure user registration and login
  - Spring Security integration
  - Role-based access control

- 📦 **Item Management**
  - Add, view, and manage shared items
  - Detailed item information and descriptions
  - RESTful API for seamless integration

- 💬 **Real-time Chat System**
  - Send and receive messages between users
  - Friend management system
  - Message history tracking

- 🔒 **Security & Privacy**
  - Password encryption
  - Secure API endpoints
  - Data validation and error handling

### 🛠️ Technology Stack

**Backend:**

- Java 17
- Spring Boot 3.4.3
- Spring Data JPA
- Spring Security
- MySQL 8.0

**Build Tool:**

- Maven

**Architecture:**

- RESTful API
- MVC Design Pattern
- Repository Pattern

### 📋 Prerequisites

- Java Development Kit (JDK) 17 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher
- IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

### 🚀 Quick Start

#### 1. Clone the Repository

```bash
git clone https://github.com/psmarter/Campus_Spring_boot.git
cd campus-item-sharing
```

#### 2. Database Setup

Create a MySQL database:

```sql
CREATE DATABASE campus_item_sharing;
```

#### 3. Configure Application

Copy the example configuration file:

```bash
cp src/main/resources/application-example.properties src/main/resources/application.properties
```

Edit `application.properties` with your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/campus_item_sharing
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

#### 4. Build and Run

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### 📚 API Documentation

#### User Management APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/users/register` | Register a new user |
| POST | `/api/users/login` | User login |
| GET | `/api/users/all` | Get all users |

#### Item Management APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/items/add` | Add a new item |
| GET | `/api/items/all` | Get all items |

#### Chat & Friends APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/friends/add` | Add a friend |
| GET | `/api/friends/all` | Get all friends |
| POST | `/api/chat/send` | Send a message |
| GET | `/api/chat/messages` | Get message history |

For detailed API documentation, see [API.md](./API.md)

### 📁 Project Structure

```
campus-item-sharing/
├── src/
│   ├── main/
│   │   ├── java/com/example/campusitemsharing/
│   │   │   ├── CampusItemSharingApplication.java  # Main application entry
│   │   │   ├── SecurityConfig.java                # Security configuration
│   │   │   ├── GlobalExceptionHandler.java        # Global exception handling
│   │   │   ├── User.java                          # User entity
│   │   │   ├── ItemInfo.java                      # Item entity
│   │   │   ├── UserController.java                # User REST controller
│   │   │   ├── ItemInfoController.java            # Item REST controller
│   │   │   └── chat/                              # Chat module
│   │   │       ├── ChatController.java
│   │   │       ├── FriendController.java
│   │   │       ├── Message.java
│   │   │       └── ...
│   │   └── resources/
│   │       ├── application.properties             # Application configuration
│   │       ├── static/                            # Static resources
│   │       └── templates/                         # Templates
│   └── test/                                      # Test cases
├── pom.xml                                        # Maven configuration
└── README.md                                      # This file
```

### 🤝 Contributing

Contributions are welcome! Please read our [Contributing Guide](./CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

### 📄 License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.

### 👥 Authors

- **psmarter** - *Initial work* - [GitHub](https://github.com/psmarter)

### 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- All contributors who help improve this project

### 📧 Contact

If you have any questions or suggestions, feel free to:

- Open an issue on GitHub
- Contact the author through GitHub

---

## 中文

### 📖 项目简介

校园物品共享平台是一个全栈 Web 应用程序，旨在帮助大学生在校园社区内共享、交换和管理物品。采用 Spring Boot 和现代 Java 技术构建，为学生提供安全高效的资源共享方式。

### ✨ 功能特性

- 🔐 **用户认证与授权**
  - 安全的用户注册和登录
  - Spring Security 集成
  - 基于角色的访问控制

- 📦 **物品管理**
  - 添加、查看和管理共享物品
  - 详细的物品信息和描述
  - RESTful API 无缝集成

- 💬 **实时聊天系统**
  - 用户间消息收发
  - 好友管理系统
  - 消息历史记录追踪

- 🔒 **安全与隐私**
  - 密码加密
  - 安全的 API 端点
  - 数据验证和错误处理

### 🛠️ 技术栈

**后端：**

- Java 17
- Spring Boot 3.4.3
- Spring Data JPA
- Spring Security
- MySQL 8.0

**构建工具：**

- Maven

**架构：**

- RESTful API
- MVC 设计模式
- 仓储模式

### 📋 前置要求

- Java 开发工具包 (JDK) 17 或更高版本
- Maven 3.6 或更高版本
- MySQL 8.0 或更高版本
- IDE（推荐使用 IntelliJ IDEA、Eclipse 或 VS Code）

### 🚀 快速开始

#### 1. 克隆仓库

```bash
git clone https://github.com/psmarter/Campus_Spring_boot.git
cd campus-item-sharing
```

#### 2. 数据库配置

创建 MySQL 数据库：

```sql
CREATE DATABASE campus_item_sharing;
```

#### 3. 配置应用

复制示例配置文件：

```bash
cp src/main/resources/application-example.properties src/main/resources/application.properties
```

编辑 `application.properties`，填入你的数据库凭据：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/campus_item_sharing
spring.datasource.username=你的用户名
spring.datasource.password=你的密码
```

#### 4. 构建并运行

```bash
# 构建项目
mvn clean install

# 运行应用
mvn spring-boot:run
```

应用将在 `http://localhost:8080` 启动

### 📚 API 文档

#### 用户管理 API

| 方法 | 端点 | 描述 |
|------|------|------|
| POST | `/api/users/register` | 注册新用户 |
| POST | `/api/users/login` | 用户登录 |
| GET | `/api/users/all` | 获取所有用户 |

#### 物品管理 API

| 方法 | 端点 | 描述 |
|------|------|------|
| POST | `/api/items/add` | 添加新物品 |
| GET | `/api/items/all` | 获取所有物品 |

#### 聊天与好友 API

| 方法 | 端点 | 描述 |
|------|------|------|
| POST | `/api/friends/add` | 添加好友 |
| GET | `/api/friends/all` | 获取所有好友 |
| POST | `/api/chat/send` | 发送消息 |
| GET | `/api/chat/messages` | 获取消息历史 |

详细 API 文档请查看 [API.md](./API.md)

### 📁 项目结构

```
campus-item-sharing/
├── src/
│   ├── main/
│   │   ├── java/com/example/campusitemsharing/
│   │   │   ├── CampusItemSharingApplication.java  # 主应用入口
│   │   │   ├── SecurityConfig.java                # 安全配置
│   │   │   ├── GlobalExceptionHandler.java        # 全局异常处理
│   │   │   ├── User.java                          # 用户实体
│   │   │   ├── ItemInfo.java                      # 物品实体
│   │   │   ├── UserController.java                # 用户 REST 控制器
│   │   │   ├── ItemInfoController.java            # 物品 REST 控制器
│   │   │   └── chat/                              # 聊天模块
│   │   │       ├── ChatController.java
│   │   │       ├── FriendController.java
│   │   │       ├── Message.java
│   │   │       └── ...
│   │   └── resources/
│   │       ├── application.properties             # 应用配置
│   │       ├── static/                            # 静态资源
│   │       └── templates/                         # 模板文件
│   └── test/                                      # 测试用例
├── pom.xml                                        # Maven 配置
└── README.md                                      # 本文件
```

### 🤝 贡献

欢迎贡献！请阅读我们的[贡献指南](./CONTRIBUTING.md)了解我们的行为准则和提交 Pull Request 的流程。

### 📄 许可证

本项目采用 MIT 许可证 - 详见 [LICENSE](./LICENSE) 文件

### 👥 作者

- **psmarter** - *初始工作* - [GitHub](https://github.com/psmarter)

### 🙏 致谢

- Spring Boot 团队提供的优秀框架
- 所有帮助改进本项目的贡献者

### 📧 联系方式

如有任何问题或建议，欢迎：

- 在 GitHub 上提 Issue
- 通过 GitHub 联系作者

---

<div align="center">

**⭐ If you find this project useful, please consider giving it a star! ⭐**

**⭐ 如果这个项目对你有帮助，请考虑给它一个 Star！⭐**

</div>
