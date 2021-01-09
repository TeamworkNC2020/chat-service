package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.entity.Attachment;
import com.moviesandchill.chatservice.repository.AttachmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(
        path = "api/attachments",
        produces = "application/json"
)
public class AttachmentController {

    private final AttachmentRepository attachmentRepository;

    public AttachmentController(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @GetMapping()
    private List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }
}
