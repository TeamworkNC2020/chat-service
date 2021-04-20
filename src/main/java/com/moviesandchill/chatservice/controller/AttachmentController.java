package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.dto.attachment.AttachmentDto;
import com.moviesandchill.chatservice.dto.attachment.NewAttachmentDto;
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

    @GetMapping
    public List<AttachmentDto> getAllAttachments() {
        return attachmentService.getAllAttachments();
    }

    @PostMapping
    public AttachmentDto addAttachment(NewAttachmentDto attachmentDto) {
        return attachmentService.addAttachment(attachmentDto);
    }

    @DeleteMapping
    public void deleteAllAttachments() {
        attachmentService.deleteAllAttachments();
    }

    @GetMapping("/{id}")
    private AttachmentDto getAttachmentById(@PathVariable("id") long attachmentId) {
        return attachmentService.getAttachmentById(attachmentId);
    }

    @DeleteMapping("/{id}")
    private void deleteChatById(@PathVariable("id") long attachmentId) {
        attachmentService.deleteAttachmentById(attachmentId);
    }
}
