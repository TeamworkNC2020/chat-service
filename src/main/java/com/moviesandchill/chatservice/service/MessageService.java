package com.moviesandchill.chatservice.service;

import com.moviesandchill.chatservice.entity.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    List<Message> getAllMessages();

    Optional<Message> getMessageById(long messageId);

    List<Message> getMessagesByChatId(long chatId);

    Message addMessage(Message message);

    void deleteMessageById(long messageId);
}
