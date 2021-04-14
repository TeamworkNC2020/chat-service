package com.moviesandchill.chatservice.repository;

import com.moviesandchill.chatservice.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    Optional<Chat> findByChatId(long chatId);

    void deleteByChatId(long chatId);
}
