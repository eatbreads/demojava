package com.chat.demo.entity;

import com.chat.demo.entity.DTO.ChatRoomDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_room_members") // 指定数据库表名为 chat_room_members
public class ChatRoomMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @Column(name = "chat_room_id", nullable = false)
    private Long chatRoomId; // 聊天室 ID

    @Column(name = "user_id", nullable = false)
    private Long userId; // 用户 ID

    @Column(name = "joined_at")
    private LocalDateTime joinedAt; // 加入时间

    @Column(name = "is_active")
    private Boolean isActive; // 是否活跃

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
