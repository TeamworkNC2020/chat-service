package com.moviesandchill.chatservice.repository;

import com.moviesandchill.chatservice.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    Optional<Attachment> findByAttachmentId(long attachmentId);

    void deleteByAttachmentId(long attachmentId);
}
