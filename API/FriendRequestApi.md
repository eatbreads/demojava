# FriendRequest API 文档

## 概述
`FriendRequestController` 提供了好友请求的相关接口，包括创建好友请求、审批或拒绝好友请求，以及查询发送或接收的好友请求列表。

### 基础 URL
```
/friend-requests
```

---

## 1. 创建好友请求

### 描述
发送一条好友请求。

### HTTP 方法
`POST`

### URL
```
/friend-requests
```

### 请求参数

#### 请求体 (JSON 格式)
| 参数名           | 类型   | 必填 | 描述                |
| ---------------- | ------ | ---- | ------------------- |
| senderUserId     | Long   | 是   | 发起请求的用户 ID   |
| receiverUserId   | Long   | 是   | 接收请求的用户 ID   |
| announcement     | String | 否   | 附加的好友请求信息  |

#### 示例
```json
{
  "senderUserId": 1,
  "receiverUserId": 2,
  "announcement": "Hi, let's connect!"
}
```

### 响应
| 字段名         | 类型   | 描述                      |
| -------------- | ------ | ------------------------- |
| data           | Object | 新创建的好友请求对象      |

#### 示例
```json
{
  "status": "success",
  "data": {
    "id": 1001,
    "senderUserId": 1,
    "receiverUserId": 2,
    "announcement": "Hi, let's connect!",
    "status": "PENDING"
  }
}
```

---

## 2. 同意好友请求

### 描述
批准指定的好友请求。

### HTTP 方法
`POST`

### URL
```
/friend-requests/{requestId}/approve
```

### 路径参数
| 参数名     | 类型   | 必填 | 描述             |
| ---------- | ------ | ---- | ---------------- |
| requestId  | Long   | 是   | 好友请求的 ID    |

### 响应
| 字段名         | 类型   | 描述                      |
| -------------- | ------ | ------------------------- |
| data           | Void   | 无返回数据                |

#### 示例
```json
{
  "status": "success",
  "data": null
}
```

---

## 3. 拒绝好友请求

### 描述
拒绝指定的好友请求。

### HTTP 方法
`POST`

### URL
```
/friend-requests/{requestId}/reject
```

### 路径参数
| 参数名     | 类型   | 必填 | 描述             |
| ---------- | ------ | ---- | ---------------- |
| requestId  | Long   | 是   | 好友请求的 ID    |

### 响应
| 字段名         | 类型   | 描述                      |
| -------------- | ------ | ------------------------- |
| data           | Void   | 无返回数据                |

#### 示例
```json
{
  "status": "success",
  "data": null
}
```

---

## 4. 查询发送的好友请求

### 描述
获取指定用户发送的好友请求列表。

### HTTP 方法
`GET`

### URL
```
/friend-requests/sent/{senderUserId}
```

### 路径参数
| 参数名         | 类型   | 必填 | 描述                   |
| -------------- | ------ | ---- | ---------------------- |
| senderUserId   | Long   | 是   | 发起请求的用户 ID      |

### 响应
| 字段名         | 类型     | 描述                       |
| -------------- | -------- | -------------------------- |
| data           | Array    | 包含发送好友请求的列表     |

#### 示例
```json
{
  "status": "success",
  "data": [
    {
      "id": 1001,
      "senderUserId": 1,
      "receiverUserId": 2,
      "announcement": "Hi, let's connect!",
      "status": "PENDING"
    }
  ]
}
```

---

## 5. 查询收到的好友请求

### 描述
获取指定用户收到的好友请求列表。

### HTTP 方法
`GET`

### URL
```
/friend-requests/received/{receiverUserId}
```

### 路径参数
| 参数名         | 类型   | 必填 | 描述                   |
| -------------- | ------ | ---- | ---------------------- |
| receiverUserId | Long   | 是   | 接收请求的用户 ID      |

### 响应
| 字段名         | 类型     | 描述                       |
| -------------- | -------- | -------------------------- |
| data           | Array    | 包含接收好友请求的列表     |

#### 示例
```json
{
  "status": "success",
  "data": [
    {
      "id": 1002,
      "senderUserId": 3,
      "receiverUserId": 2,
      "announcement": "Would love to connect!",
      "status": "PENDING"
    }
  ]
}
```

---

## 公共响应结构

| 字段名         | 类型     | 描述                     |
| -------------- | -------- | ------------------------ |
| status         | String   | 响应状态 (`success` 或 `error`) |
| data           | Object   | 返回的数据               |
| message        | String   | 响应的描述信息           |

### 示例
```json
{
  "status": "success",
  "data": null,
  "message": "操作成功"
}
```