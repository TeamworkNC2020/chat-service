package com.moviesandchill.chatservice.repository;

import com.moviesandchill.chatservice.entity.Attachment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
    @Override
    @SuppressWarnings("NullableProblems")
    List<Attachment> findAll();
}
