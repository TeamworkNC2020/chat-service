package com.moviesandchill.chatservice.repository;

import com.moviesandchill.chatservice.entity.Chat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatRepository extends CrudRepository<Chat, Long> {
    @Override
    @SuppressWarnings("NullableProblems")
    List<Chat> findAll();
}
