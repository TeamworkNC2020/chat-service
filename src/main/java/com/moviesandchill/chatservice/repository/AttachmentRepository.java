package com.moviesandchill.chatservice.repository;

import com.moviesandchill.chatservice.entity.Attachment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
    @Override
    @SuppressWarnings("NullableProblems")
    List<Attachment> findAll();

    Optional<Attachment> findByAttachmentId(long attachmentId);

    void deleteByAttachmentId(long attachmentId);
}
