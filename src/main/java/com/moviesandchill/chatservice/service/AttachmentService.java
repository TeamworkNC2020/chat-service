package com.moviesandchill.chatservice.service;

import com.moviesandchill.chatservice.dto.attachment.AttachmentDto;
import com.moviesandchill.chatservice.dto.attachment.NewAttachmentDto;

import java.util.List;

public interface AttachmentService {
    List<AttachmentDto> getAllAttachments();

    AttachmentDto addAttachment(NewAttachmentDto dto);

    void deleteAllAttachments();

    AttachmentDto getAttachmentById(long attachmentId);

    void deleteAttachmentById(long attachmentId);
}
