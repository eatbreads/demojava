以下是 **ChatRoomMember API** 的文档说明，基于 RESTful 风格和统一返回格式：

---

## **ChatRoomMember API 文档**

### **基本信息**
- **Base URL**: `/chat-room-members`
- **Response 格式**: 
    - 成功：`{"code": 200, "message": "Success", "data": <实际数据>}`
    - 失败：`{"code": 500, "message": "错误描述", "data": null}`

---

### **1. 添加成员到聊天室**

- **URL**: `/chat-room-members`
- **请求方法**: `POST`
- **描述**: 添加一个成员到指定聊天室。
- **请求头**:
  - `Content-Type: application/json`
- **请求体**:

```json
{
  "chatRoomId": 100,
  "userId": 200,
  "role": "member" 
}
```

- **响应**:

**成功**:
```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "id": 1,
    "chatRoomId": 100,
    "userId": 200,
    "role": "member",
    "joinedAt": "2024-11-24T15:30:00"
  }
}
```

**失败**:
```json
{
  "code": 500,
  "message": "Failed to add member to chat room",
  "data": null
}
```

---

### **2. 获取聊天室的所有成员**

- **URL**: `/chat-room-members/chat-room/{chatRoomId}`
- **请求方法**: `GET`
- **描述**: 获取指定聊天室的所有成员。
- **路径参数**:
  - `chatRoomId` (Long): 聊天室的唯一标识。
- **响应**:

**成功**:
```json
{
  "code": 200,
  "message": "Success",
  "data": [
    {
      "id": 1,
      "chatRoomId": 100,
      "userId": 200,
      "role": "member",
      "joinedAt": "2024-11-24T15:30:00"
    },
    {
      "id": 2,
      "chatRoomId": 100,
      "userId": 201,
      "role": "admin",
      "joinedAt": "2024-11-24T16:00:00"
    }
  ]
}
```

**失败**:
```json
{
  "code": 500,
  "message": "Failed to fetch members for the chat room",
  "data": null
}
```
---

### **3. 根据用户 ID 获取聊天室 DTO 列表**
- **URL**: `/chat-room-members/user/{userId}/chat-rooms`
- **请求方法**: `GET`
- **描述**: 根据用户 ID 获取该用户加入的所有聊天室的 DTO 列表。
- **路径参数**:
  - `userId` (Long): 用户的唯一标识。
  - **响应**:

**成功**:
```json
{
  "code": 200,
  "message": "Success",
  "data": [
    {
      "id": 100,
      "name": "Java Chat Room",
      "description": "A chat room for Java developers",
      "createdAt": "2024-11-24T15:00:00",
      "createdBy": 200
    },
    {
      "id": 101,
      "name": "Python Chat Room",
      "description": "A chat room for Python developers",
      "createdAt": "2024-11-24T16:00:00",
      "createdBy": 201
    }
  ]
}
```

**失败**:
```json
{
  "code": 500,
  "message": "Failed to fetch chat rooms for the user",
  "data": null
}
```

---

### **4. 从聊天室移除成员**

- **URL**: `/chat-room-members/{id}`
- **请求方法**: `DELETE`
- **描述**: 根据成员 ID 移除指定的聊天室成员。
- **路径参数**:
  - `id` (Long): 聊天室成员的唯一标识。
- **响应**:

**成功**:
```json
{
  "code": 200,
  "message": "Success",
  "data": null
}
```

**失败**:
```json
{
  "code": 500,
  "message": "Failed to remove member with id: 2",
  "data": null
}
```

---

### **错误状态码**

| 状态码 | 描述                  |
|--------|-----------------------|
| 200    | 请求成功              |
| 500    | 请求失败，包含错误信息 |

---

### **示例请求和响应**

#### **1. 添加成员到聊天室**

**请求**:
```http
POST /chat-room-members HTTP/1.1
Content-Type: application/json

{
  "chatRoomId": 100,
  "userId": 200,
  "role": "member"
}
```

**响应**:
```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "id": 1,
    "chatRoomId": 100,
    "userId": 200,
    "role": "member",
    "joinedAt": "2024-11-24T15:30:00"
  }
}
```

#### **2. 获取聊天室的所有成员**

**请求**:
```http
GET /chat-room-members/chat-room/100 HTTP/1.1
```

**响应**:
```json
{
  "code": 200,
  "message": "Success",
  "data": [
    {
      "id": 1,
      "chatRoomId": 100,
      "userId": 200,
      "role": "member",
      "joinedAt": "2024-11-24T15:30:00"
    },
    {
      "id": 2,
      "chatRoomId": 100,
      "userId": 201,
      "role": "admin",
      "joinedAt": "2024-11-24T16:00:00"
    }
  ]
}
```

#### **3. 删除聊天室成员**

**请求**:
```http
DELETE /chat-room-members/1 HTTP/1.1
```

**响应**:
```json
{
  "code": 200,
  "message": "Success",
  "data": null
}
``` 

--- 
