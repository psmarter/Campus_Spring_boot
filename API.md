# API Documentation / API 文档

[English](#english) | [中文](#中文)

---

## English

### Base URL

```
http://localhost:8080
```

### Authentication

All API endpoints (except public ones) require authentication. The application uses Spring Security for authentication.

---

## User Management APIs / 用户管理 API

### 1. Register User / 注册用户

**Endpoint:** `POST /api/users/register`

**Description:** Register a new user account

**Request Body:**

```json
{
  "username": "string",
  "password": "string",
  "email": "string",
  "phoneNumber": "string"
}
```

**Response (Success - 201 Created):**

```json
{
  "status": "success",
  "message": "User registered successfully",
  "data": {
    "userId": 1,
    "username": "john_doe"
  }
}
```

**Response (Error - 400 Bad Request):**

```json
{
  "status": "error",
  "message": "Username already exists"
}
```

---

### 2. User Login / 用户登录

**Endpoint:** `POST /api/users/login`

**Description:** Authenticate user and create session

**Request Body:**

```json
{
  "username": "string",
  "password": "string"
}
```

**Response (Success - 200 OK):**

```json
{
  "status": "success",
  "message": "Login successful",
  "data": {
    "userId": 1,
    "username": "john_doe",
    "token": "jwt_token_here"
  }
}
```

**Response (Error - 401 Unauthorized):**

```json
{
  "status": "error",
  "message": "Invalid username or password"
}
```

---

### 3. Get All Users / 获取所有用户

**Endpoint:** `GET /api/users/all`

**Description:** Retrieve a list of all registered users

**Response (Success - 200 OK):**

```json
[
  {
    "userId": 1,
    "username": "john_doe",
    "email": "john@example.com",
    "phoneNumber": "1234567890"
  },
  {
    "userId": 2,
    "username": "jane_smith",
    "email": "jane@example.com",
    "phoneNumber": "0987654321"
  }
]
```

---

## Item Management APIs / 物品管理 API

### 1. Add Item / 添加物品

**Endpoint:** `POST /api/items/add`

**Description:** Add a new item for sharing

**Request Body:**

```json
{
  "itemName": "string",
  "description": "string",
  "category": "string",
  "condition": "string",
  "price": 0.00,
  "userId": 1,
  "imageUrl": "string"
}
```

**Response (Success - 201 Created):**

```json
{
  "status": "success",
  "message": "Item added successfully",
  "data": {
    "itemId": 1,
    "itemName": "Textbook - Advanced Mathematics"
  }
}
```

**Response (Error - 400 Bad Request):**

```json
{
  "status": "error",
  "message": "Invalid item data"
}
```

---

### 2. Get All Items / 获取所有物品

**Endpoint:** `GET /api/items/all`

**Description:** Retrieve a list of all shared items

**Response (Success - 200 OK):**

```json
[
  {
    "itemId": 1,
    "itemName": "Textbook - Advanced Mathematics",
    "description": "Barely used, excellent condition",
    "category": "Books",
    "condition": "Like New",
    "price": 25.00,
    "ownerUsername": "john_doe",
    "imageUrl": "https://example.com/image.jpg",
    "createdAt": "2025-12-30T10:00:00"
  },
  {
    "itemId": 2,
    "itemName": "Bicycle",
    "description": "Mountain bike, good for campus commute",
    "category": "Sports",
    "condition": "Good",
    "price": 150.00,
    "ownerUsername": "jane_smith",
    "imageUrl": "https://example.com/bike.jpg",
    "createdAt": "2025-12-29T15:30:00"
  }
]
```

---

## Friend Management APIs / 好友管理 API

### 1. Add Friend / 添加好友

**Endpoint:** `POST /api/friends/add`

**Description:** Send a friend request or add a friend

**Request Body:**

```json
{
  "userId": 1,
  "friendId": 2
}
```

**Response (Success - 201 Created):**

```json
{
  "status": "success",
  "message": "Friend added successfully"
}
```

**Response (Error - 400 Bad Request):**

```json
{
  "status": "error",
  "message": "Friendship already exists"
}
```

---

### 2. Get All Friends / 获取所有好友

**Endpoint:** `GET /api/friends/all`

**Description:** Retrieve user's friend list

**Query Parameters:**

- `userId` (required): User ID

**Response (Success - 200 OK):**

```json
[
  {
    "userId": 2,
    "username": "jane_smith",
    "email": "jane@example.com",
    "status": "active"
  },
  {
    "userId": 3,
    "username": "bob_wilson",
    "email": "bob@example.com",
    "status": "active"
  }
]
```

---

## Chat & Messaging APIs / 聊天消息 API

### 1. Send Message / 发送消息

**Endpoint:** `POST /api/chat/send`

**Description:** Send a message to another user

**Request Body:**

```json
{
  "senderId": 1,
  "receiverId": 2,
  "messageContent": "Hello! Is the textbook still available?",
  "messageType": "text"
}
```

**Response (Success - 201 Created):**

```json
{
  "status": "success",
  "message": "Message sent successfully",
  "data": {
    "messageId": 123,
    "timestamp": "2025-12-30T10:30:00"
  }
}
```

---

### 2. Get Message History / 获取消息历史

**Endpoint:** `GET /api/chat/messages`

**Description:** Retrieve chat history between two users

**Query Parameters:**

- `userId` (required): Current user ID
- `friendId` (required): Friend's user ID
- `limit` (optional): Number of messages to retrieve (default: 50)
- `offset` (optional): Pagination offset (default: 0)

**Response (Success - 200 OK):**

```json
[
  {
    "messageId": 123,
    "senderId": 1,
    "senderUsername": "john_doe",
    "receiverId": 2,
    "receiverUsername": "jane_smith",
    "messageContent": "Hello! Is the textbook still available?",
    "messageType": "text",
    "timestamp": "2025-12-30T10:30:00",
    "isRead": false
  },
  {
    "messageId": 122,
    "senderId": 2,
    "senderUsername": "jane_smith",
    "receiverId": 1,
    "receiverUsername": "john_doe",
    "messageContent": "Yes! It's still available.",
    "messageType": "text",
    "timestamp": "2025-12-30T10:35:00",
    "isRead": true
  }
]
```

---

## Error Responses / 错误响应

All API endpoints return consistent error responses in the following format:

所有 API 端点返回以下格式的一致错误响应：

```json
{
  "status": "error",
  "message": "Error description",
  "timestamp": "2025-12-30T10:00:00",
  "path": "/api/endpoint"
}
```

### Common HTTP Status Codes / 常见 HTTP 状态码

| Code | Description (EN) | Description (CN) |
|------|------------------|------------------|
| 200 | OK - Request successful | 请求成功 |
| 201 | Created - Resource created | 资源已创建 |
| 400 | Bad Request - Invalid input | 无效输入 |
| 401 | Unauthorized - Authentication required | 需要认证 |
| 403 | Forbidden - Access denied | 访问被拒绝 |
| 404 | Not Found - Resource not found | 资源未找到 |
| 500 | Internal Server Error - Server error | 服务器错误 |

---

## Request Examples / 请求示例

### Using cURL

#### Register a new user / 注册新用户

```bash
curl -X POST http://localhost:8080/api/users/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "john_doe",
    "password": "securePassword123",
    "email": "john@example.com",
    "phoneNumber": "1234567890"
  }'
```

#### Add a new item / 添加新物品

```bash
curl -X POST http://localhost:8080/api/items/add \
  -H "Content-Type: application/json" \
  -d '{
    "itemName": "Textbook - Advanced Mathematics",
    "description": "Barely used, excellent condition",
    "category": "Books",
    "condition": "Like New",
    "price": 25.00,
    "userId": 1,
    "imageUrl": "https://example.com/image.jpg"
  }'
```

#### Get all items / 获取所有物品

```bash
curl -X GET http://localhost:8080/api/items/all \
  -H "Content-Type: application/json"
```

---

### Using JavaScript (Fetch API)

#### Register a new user / 注册新用户

```javascript
fetch('http://localhost:8080/api/users/register', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
  },
  body: JSON.stringify({
    username: 'john_doe',
    password: 'securePassword123',
    email: 'john@example.com',
    phoneNumber: '1234567890'
  })
})
.then(response => response.json())
.then(data => console.log(data))
.catch(error => console.error('Error:', error));
```

#### Get all items / 获取所有物品

```javascript
fetch('http://localhost:8080/api/items/all')
  .then(response => response.json())
  .then(items => console.log(items))
  .catch(error => console.error('Error:', error));
```

---

## Notes / 注意事项

### English

1. **Authentication**: Most endpoints require authentication. Implement proper session management or JWT tokens.
2. **CORS**: Configure CORS settings for cross-origin requests in production.
3. **Rate Limiting**: Consider implementing rate limiting to prevent abuse.
4. **Validation**: All inputs are validated server-side. Ensure client-side validation matches.
5. **HTTPS**: Use HTTPS in production for secure data transmission.

### 中文

1. **认证**：大多数端点需要认证。实现适当的会话管理或 JWT 令牌。
2. **CORS**：为生产环境中的跨域请求配置 CORS 设置。
3. **速率限制**：考虑实现速率限制以防止滥用。
4. **验证**：所有输入都在服务器端验证。确保客户端验证匹配。
5. **HTTPS**：在生产环境中使用 HTTPS 进行安全数据传输。

---

## Support / 支持

For API support or questions:

- Open an issue on GitHub
- Contact: [GitHub Repository](https://github.com/psmarter/Campus_Spring_boot)

如有 API 支持或问题：

- 在 GitHub 上提 Issue
- 联系：[GitHub 仓库](https://github.com/psmarter/Campus_Spring_boot)
