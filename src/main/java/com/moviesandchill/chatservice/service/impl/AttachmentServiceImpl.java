package com.moviesandchill.chatservice.service.impl;

import com.moviesandchill.chatservice.entity.Attachment;
import com.moviesandchill.chatservice.repository.AttachmentRepository;
import com.moviesandchill.chatservice.service.AttachmentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    @Override
    public Optional<Attachment> getAttachmentById(long attachmentId) {
        return attachmentRepository.findById(attachmentId);
    }

    @Override
    public void deleteAttachmentById(long chatId) {
        attachmentRepository.deleteByAttachmentId(chatId);
    }
}
