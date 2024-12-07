# Friendship API 文档

## 概述
`FriendshipController` 提供了管理用户好友关系的接口，包括添加好友、查询好友列表和删除好友关系。

### 基础 URL
```
/friendships
```

---

## 1. 添加好友

### 描述
为用户添加一位好友。

### HTTP 方法
`POST`

### URL
```
/friendships/friends
```

### 请求参数

#### 请求体 (JSON 格式)
| 参数名         | 类型   | 必填 | 描述                 |
| -------------- | ------ | ---- | -------------------- |
| user1Id        | Long   | 是   | 用户 ID             |
| user2Id        | Long   | 是   | 好友的用户 ID       |

#### 示例
```json
{
  "user1Id": 1,
  "user2Id": 2
}
```

### 响应
| 字段名         | 类型   | 描述                       |
| -------------- | ------ | -------------------------- |
| data           | Object | 新建的好友关系对象         |

#### 示例
```json
{
  "status": "success",
  "data": {
    "id": 1001,
    "user1Id": 1,
    "user2Id": 2
  }
}
```

---

## 2. 查询好友列表

### 描述
获取指定用户的所有好友关系。

### HTTP 方法
`GET`

### URL
```
/friendships/users/{userId}
```

### 路径参数
| 参数名 | 类型   | 必填 | 描述       |
| ------ | ------ | ---- | ---------- |
| userId | Long   | 是   | 用户 ID    |

### 响应
| 字段名         | 类型   | 描述                       |
| -------------- | ------ | -------------------------- |
| data           | Array  | 包含好友关系的列表         |

#### 示例
```json
{
  "status": "success",
  "data": [
    {
      "id": 1001,
      "user1Id": 1,
      "user2Id": 2
    },
    {
      "id": 1002,
      "user1Id": 1,
      "user2Id": 3
    }
  ]
}
```

---

## 3. 删除好友

### 描述
删除指定用户与某个好友的好友关系。

### HTTP 方法
`DELETE`

### URL
```
/friendships/users/{userId}/friends/{friendId}
```

### 路径参数
| 参数名   | 类型   | 必填 | 描述               |
| -------- | ------ | ---- | ------------------ |
| userId   | Long   | 是   | 用户 ID           |
| friendId | Long   | 是   | 要移除的好友的 ID |

### 响应
| 字段名         | 类型   | 描述                 |
| -------------- | ------ | -------------------- |
| data           | Void   | 无返回数据           |

#### 示例
```json
{
  "status": "success",
  "data": null
}
```

---

## 公共响应结构

| 字段名         | 类型     | 描述                 |
| -------------- | -------- | -------------------- |
| status         | String   | 响应状态 (`success` 或 `error`) |
| data           | Object   | 返回的数据           |
| message        | String   | 响应的描述信息       |

### 示例
```json
{
  "status": "success",
  "data": null,
  "message": "操作成功"
}
```