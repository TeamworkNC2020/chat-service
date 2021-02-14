package com.moviesandchill.chatservice.service;

import com.moviesandchill.chatservice.entity.Attachment;

import java.util.List;
import java.util.Optional;

public interface AttachmentService {
    List<Attachment> getAllAttachments();

    Optional<Attachment> getAttachmentById(long attachmentId);

    void deleteAttachmentById(long attachmentId);
}
