package com.chat.demo.controller;

import com.chat.demo.entity.DTO.AttachmentDto;
import com.chat.demo.response.Response;
import com.chat.demo.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    /**
     * 上传附件
     * @param chatRoomId
     * @param file
     * @return
     */
    @PostMapping
    public Response<AttachmentDto> uploadAttachment(@RequestParam("chatRoomId") Long chatRoomId,
                                                    @RequestParam("file") MultipartFile file) {
        try {
            // 上传附件到 MinIO，返回文件的 URL
          AttachmentDto attachment = attachmentService.uploadAttachment(file, chatRoomId);

            return Response.success(attachment);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Failed to upload attachment: " + e.getMessage());
        }
    }

    /**
     * 根据房间 ID 获取附件
     * @param roomId
     * @return
     */
    @GetMapping("/{roomId}")
    public Response<List<AttachmentDto>> getAttachmentsByChatRoomId(@PathVariable Long roomId) {
        List<AttachmentDto> attachments = attachmentService.getAttachmentsByChatRoomId(roomId);
        return attachments.isEmpty() ?
                Response.error("No attachments found for the room id") :
                Response.success(attachments);
    }

    /**
     * 删除附件
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Response<Void> deleteAttachment(@PathVariable Long id) {
        boolean success = attachmentService.deleteAttachment(id);
        return success ? Response.success(null) : Response.error("Failed to delete attachment with id: " + id);
    }
}
