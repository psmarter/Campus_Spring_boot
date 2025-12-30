# Contributing to Campus Item Sharing Platform / 为校园物品共享平台做贡献

[English](#english) | [中文](#中文)

---

## English

Thank you for your interest in contributing to Campus Item Sharing Platform! We welcome contributions from the community.

### 📋 Code of Conduct

By participating in this project, you agree to abide by our [Code of Conduct](./CODE_OF_CONDUCT.md).

### 🚀 How Can I Contribute?

#### Reporting Bugs

Before creating bug reports, please check existing issues to avoid duplicates. When you create a bug report, include as many details as possible:

- **Use a clear and descriptive title**
- **Describe the exact steps to reproduce the problem**
- **Provide specific examples**
- **Describe the behavior you observed and what you expected**
- **Include screenshots if applicable**
- **Specify your environment** (OS, Java version, etc.)

#### Suggesting Enhancements

Enhancement suggestions are tracked as GitHub issues. When creating an enhancement suggestion:

- **Use a clear and descriptive title**
- **Provide a detailed description of the suggested enhancement**
- **Explain why this enhancement would be useful**
- **List some examples of how it would be used**

#### Pull Requests

1. **Fork the repository** and create your branch from `main`
2. **Follow the coding style** of the project
3. **Add tests** if you're adding functionality
4. **Update documentation** as needed
5. **Ensure all tests pass**
6. **Write clear commit messages**
7. **Submit your pull request**

### 💻 Development Setup

1. Fork and clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/Campus_Spring_boot.git
cd campus-item-sharing
```

1. Set up the database and configuration as described in [README.md](./README.md)

2. Create a new branch:

```bash
git checkout -b feature/your-feature-name
```

1. Make your changes and test thoroughly

2. Commit your changes:

```bash
git add .
git commit -m "Add: description of your changes"
```

1. Push to your fork:

```bash
git push origin feature/your-feature-name
```

1. Create a Pull Request

### 📝 Coding Guidelines

#### Java Code Style

- Follow standard Java naming conventions
- Use meaningful variable and method names
- Add JavaDoc comments for public methods and classes
- Keep methods focused and concise
- Use proper exception handling

#### Comment Style

All code comments should be **bilingual (Chinese and English)**:

```java
/**
 * 添加新物品 / Add a new item
 * 
 * @param itemInfo 物品信息 / Item information
 * @return 响应模型 / Response model
 */
@PostMapping("/add")
public ResponseEntity<ResponseModel> addItem(@RequestBody ItemInfo itemInfo) {
    // Implementation
}
```

#### Commit Message Format

Use clear and descriptive commit messages:

- `Add: new feature description`
- `Fix: bug description`
- `Update: what was updated`
- `Refactor: what was refactored`
- `Docs: documentation changes`

### 🧪 Testing

- Write unit tests for new functionality
- Ensure existing tests pass: `mvn test`
- Test your changes in a local environment

### 📖 Documentation

- Update README.md if you change functionality
- Update API.md for API changes
- Add inline comments for complex logic
- Keep documentation bilingual (Chinese/English)

### ❓ Questions?

Feel free to:

- Open an issue with the `question` label
- Contact the maintainers through GitHub

### 🙏 Thank You

Your contributions help make this project better for everyone!

---

## 中文

感谢你对校园物品共享平台的贡献兴趣！我们欢迎来自社区的贡献。

### 📋 行为准则

参与此项目即表示你同意遵守我们的[行为准则](./CODE_OF_CONDUCT.md)。

### 🚀 如何贡献？

#### 报告 Bug

在创建 bug 报告之前，请检查现有问题以避免重复。创建 bug 报告时，请包含尽可能多的详细信息：

- **使用清晰描述性的标题**
- **描述重现问题的确切步骤**
- **提供具体示例**
- **描述你观察到的行为和预期行为**
- **如适用，包含截图**
- **指定你的环境**（操作系统、Java 版本等）

#### 建议增强功能

增强建议作为 GitHub issues 跟踪。创建增强建议时：

- **使用清晰描述性的标题**
- **提供建议增强功能的详细描述**
- **解释为什么这个增强功能有用**
- **列出一些使用示例**

#### Pull Request

1. **Fork 仓库**并从 `main` 创建你的分支
2. **遵循项目的编码风格**
3. **添加测试**（如果你在添加功能）
4. **根据需要更新文档**
5. **确保所有测试通过**
6. **编写清晰的提交消息**
7. **提交你的 pull request**

### 💻 开发设置

1. Fork 并克隆仓库：

```bash
git clone https://github.com/YOUR_USERNAME/Campus_Spring_boot.git
cd campus-item-sharing
```

1. 按照 [README.md](./README.md) 中的说明设置数据库和配置

2. 创建新分支：

```bash
git checkout -b feature/你的功能名称
```

1. 进行更改并彻底测试

2. 提交更改：

```bash
git add .
git commit -m "Add: 你的更改描述"
```

1. 推送到你的 fork：

```bash
git push origin feature/你的功能名称
```

1. 创建 Pull Request

### 📝 编码指南

#### Java 代码风格

- 遵循标准 Java 命名约定
- 使用有意义的变量和方法名
- 为公共方法和类添加 JavaDoc 注释
- 保持方法专注简洁
- 使用适当的异常处理

#### 注释风格

所有代码注释应该是**中英双语**：

```java
/**
 * 添加新物品 / Add a new item
 * 
 * @param itemInfo 物品信息 / Item information
 * @return 响应模型 / Response model
 */
@PostMapping("/add")
public ResponseEntity<ResponseModel> addItem(@RequestBody ItemInfo itemInfo) {
    // 实现代码
}
```

#### 提交消息格式

使用清晰描述性的提交消息：

- `Add: 新功能描述`
- `Fix: bug 描述`
- `Update: 更新内容`
- `Refactor: 重构内容`
- `Docs: 文档更改`

### 🧪 测试

- 为新功能编写单元测试
- 确保现有测试通过：`mvn test`
- 在本地环境测试你的更改

### 📖 文档

- 如果更改功能，请更新 README.md
- API 更改请更新 API.md
- 为复杂逻辑添加内联注释
- 保持文档双语（中文/英文）

### ❓ 有问题？

欢迎：

- 开一个带有 `question` 标签的 issue
- 通过 GitHub 联系维护者

### 🙏 谢谢

你的贡献让这个项目变得更好！
