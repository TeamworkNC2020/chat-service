package com.moviesandchill.chatservice.service;

import com.moviesandchill.chatservice.entity.Chat;

import java.util.List;
import java.util.Optional;

public interface ChatService {
    List<Chat> getAllChats();

    Optional<Chat> getChatById(long chatId);

    void deleteChatById(long chatId);
}
