package com.moviesandchill.chatservice.repository;

import com.moviesandchill.chatservice.entity.Chat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends CrudRepository<Chat, Long> {
    @Override
    @SuppressWarnings("NullableProblems")
    List<Chat> findAll();

    Optional<Chat> findByChatId(long chatId);

    void deleteByChatId(long chatId);
}
