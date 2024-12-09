package com.chat.demo.controller;

import com.chat.demo.entity.DTO.ChatRoomDto;
import com.chat.demo.entity.DTO.ChatRoomMemberDto;
import com.chat.demo.response.Response;
import com.chat.demo.service.ChatRoomMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat-room-members")
public class ChatRoomMemberController {

    @Autowired
    private ChatRoomMemberService chatRoomMemberService;

    /**
        * 添加成员到聊天室
        * @param chatRoomMember 聊天室成员
        * @return 添加的聊天室成员
     * */
    @PostMapping
    public Response<ChatRoomMemberDto> addMemberToChatRoom(@RequestBody ChatRoomMemberDto chatRoomMember) {
        ChatRoomMemberDto savedMember = chatRoomMemberService.addMemberToChatRoom(chatRoomMember);
        return Response.success(savedMember);
    }

    /**
        * 获取聊天室的所有成员
        * @param chatRoomId 聊天室 ID
        * @return 聊天室成员列表
     * */
    @GetMapping("/chat-room/{chatRoomId}")
    public Response<List<ChatRoomMemberDto>> getMembersByChatRoom(@PathVariable Long chatRoomId) {
        List<ChatRoomMemberDto> members = chatRoomMemberService.getMembersByChatRoom(chatRoomId);
        return Response.success(members);
    }

    /**
        * 根据用户 ID 获取聊天室 ID
        * @param userId 用户 ID
        * @return 聊天室 ID 列表
     * */
//    @GetMapping("/user/{userId}")
//    public Response<List<Long>> getChatRoomsByUserId(@PathVariable Long userId) {
//        List<Long> chatRoomIds = chatRoomMemberService.getChatRoomsByUserId(userId);
//        return Response.success(chatRoomIds);
//    }

    /**
        * 根据用户 ID 获取聊天室 DTO
        * @param userId 用户 ID
        * @return 聊天室 DTO 列表
     * */
    @GetMapping("/user/{userId}/chat-rooms")
    public Response<List<ChatRoomDto>> getChatRoomsByUserId(@PathVariable Long userId) {
        List<ChatRoomDto> chatRooms = chatRoomMemberService.getChatRoomDtosByUserId(userId);
        return Response.success(chatRooms);
    }

    /**
        * 从聊天室移除成员
        * @param id 成员 ID
        * @return 操作结果
     * */
    @DeleteMapping("/{id}")
    public Response<Void> removeMemberFromChatRoom(@PathVariable Long id) {
        chatRoomMemberService.removeMemberFromChatRoom(id);
        return Response.success(null);
    }
}
