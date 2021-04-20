package com.moviesandchill.chatservice.service.impl;

import com.moviesandchill.chatservice.dto.attachment.AttachmentDto;
import com.moviesandchill.chatservice.dto.attachment.NewAttachmentDto;
import com.moviesandchill.chatservice.mapper.AttachmentMapper;
import com.moviesandchill.chatservice.repository.AttachmentRepository;
import com.moviesandchill.chatservice.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService {

    private AttachmentRepository attachmentRepository;

    private AttachmentMapper attachmentMapper;

    @Override
    public List<AttachmentDto> getAllAttachments() {
        var attachments = attachmentRepository.findAll();
        return attachmentMapper.mapToDto(attachments);
    }

    @Override
    public AttachmentDto addAttachment(NewAttachmentDto dto) {
        var attachment = attachmentMapper.mapToEntity(dto);
        attachment = attachmentRepository.save(attachment);
        return attachmentMapper.mapToDto(attachment);
    }

    @Override
    public void deleteAllAttachments() {
        attachmentRepository.deleteAll();
    }

    @Override
    public AttachmentDto getAttachmentById(long attachmentId) {
        var attachment = attachmentRepository.findByAttachmentId(attachmentId)
                .orElseThrow();
        return attachmentMapper.mapToDto(attachment);
    }

    @Override
    public void deleteAttachmentById(long attachmentId) {
        attachmentRepository.deleteByAttachmentId(attachmentId);
    }

    @Autowired
    public void setAttachmentRepository(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Autowired
    public void setAttachmentMapper(AttachmentMapper attachmentMapper) {
        this.attachmentMapper = attachmentMapper;
    }
}
