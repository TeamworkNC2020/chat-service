package com.moviesandchill.chatservice.service;

import com.moviesandchill.chatservice.dto.chat.ChatDto;
import com.moviesandchill.chatservice.dto.chat.NewChatDto;

import java.util.List;

public interface ChatService {
    List<ChatDto> getAllChats();

    ChatDto addChat(NewChatDto newChatDto);

    void deleteAllChats();

    ChatDto getChatById(long chatId);

    void deleteChatById(long chatId);
}
