package com.moviesandchill.chatservice.repository;

import com.moviesandchill.chatservice.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByChatIdEquals(long chatId);

    Optional<Message> findByMessageId(long messageId);

    List<Message> findByChatId(long chatId);

    void deleteByMessageIdEquals(long messageId);
}
