package com.chat.demo.repository;

import com.chat.demo.entity.ChatRoomMember;
import com.chat.demo.entity.DTO.ChatRoomDto;
import com.chat.demo.entity.DTO.ChatRoomMemberDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRoomMemberRepository extends JpaRepository<ChatRoomMember, Long> {
    // 根据聊天室 ID 查找所有成员

    List<ChatRoomMember> findByChatRoomId(Long chatRoomId);

    List<ChatRoomMember> findByUserId(Long userId);

    // 检查用户是否在某个聊天室中
    boolean existsByChatRoomIdAndUserId(Long chatRoomId, Long userId);

    // 自定义查询，根据用户ID查找聊天室ID
    @Query("SELECT c.chatRoomId FROM ChatRoomMember c WHERE c.userId = :userId")
    List<Long> findChatRoomIdsByUserId(@Param("userId") Long userId);
}

