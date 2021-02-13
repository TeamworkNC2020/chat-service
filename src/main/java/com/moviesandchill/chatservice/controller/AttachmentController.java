package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.entity.Attachment;
import com.moviesandchill.chatservice.service.AttachmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "api/v1/attachments",
        produces = "application/json"
)
public class AttachmentController {

    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping()
    private List<Attachment> getAllAttachments() {
        return attachmentService.getAllAttachments();
    }

    @GetMapping("/{id}")
    private Attachment getAttachmentById(@PathVariable("id") long attachmentId) {
        return attachmentService.getAttachmentById(attachmentId).orElseThrow();
    }

    @DeleteMapping("/{id}")
    private void deleteChatById(@PathVariable("id") long attachmentId) {
        attachmentService.deleteAttachmentById(attachmentId);
    }
}
