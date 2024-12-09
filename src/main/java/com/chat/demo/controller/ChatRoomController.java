package com.chat.demo.controller;

import com.chat.demo.entity.DTO.ChatRoomDto;
import com.chat.demo.response.Response;
import com.chat.demo.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat-rooms")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    /**
     * 创建聊天室
     * @param chatRoom 聊天室
     * @return 创建的聊天室
     */
    @PostMapping
    public Response<ChatRoomDto> createChatRoom(@RequestBody ChatRoomDto chatRoom) {
        ChatRoomDto createdChatRoom = chatRoomService.createChatRoom(chatRoom);
        if (createdChatRoom == null) {
            return Response.error("Failed to create chat room");
        }
        return Response.success(createdChatRoom);
    }

    /**
     * 获取所有聊天室
     * @return 聊天室列表
     */
    @GetMapping
    public Response<List<ChatRoomDto>> getAllChatRooms() {
        List<ChatRoomDto> chatRooms = chatRoomService.getAllChatRooms();
        return Response.success(chatRooms);
    }

    /**
     * 根据 ID 获取聊天室
     * @param id 聊天室 ID
     * @return 聊天室
     */
    @GetMapping("/{id}")
    public Response<ChatRoomDto> getChatRoomById(@PathVariable Long id) {
        ChatRoomDto chatRoom = chatRoomService.getChatRoomById(id);
        if (chatRoom == null) {
            return Response.error("Chat room not found");
        }
        return Response.success(chatRoom);
    }

    /**
     * 删除聊天室
     * @param id 聊天室 ID
     * @return 操作结果
     */
    @DeleteMapping("/{id}")
    public Response<Void> deleteChatRoom(@PathVariable Long id) {
        boolean deleted = chatRoomService.deleteChatRoom(id);
        if (!deleted) {
            return Response.error("Chat room not found or could not be deleted");
        }
        return Response.success(null);
    }

    /**
     * 更新聊天室
     * @param id 聊天室 ID
     * @param chatRoom 聊天室
     * @return 更新后的聊天室
     */
    @PutMapping("/{id}")
    public Response<ChatRoomDto> updateChatRoom(@PathVariable Long id, @RequestBody ChatRoomDto chatRoom) {
        ChatRoomDto updatedChatRoom = chatRoomService.updateChatRoom(id, chatRoom);
        if (updatedChatRoom == null) {
            return Response.error("Failed to update chat room");
        }
        return Response.success(updatedChatRoom);
    }
}
