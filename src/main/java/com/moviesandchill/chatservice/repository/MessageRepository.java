package com.moviesandchill.chatservice.repository;

import com.moviesandchill.chatservice.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends CrudRepository<Message, Long> {
    @Override
    @SuppressWarnings("NullableProblems")
    List<Message> findAll();

    Optional<Message> findByMessageId(long messageId);

    List<Message> findByChatId(long chatId);

    void deleteByMessageId(long messageId);
}
