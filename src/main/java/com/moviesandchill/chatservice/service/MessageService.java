package com.moviesandchill.chatservice.service;

import com.moviesandchill.chatservice.dto.message.MessageDto;
import com.moviesandchill.chatservice.dto.message.NewMessageDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getAllMessages();

    MessageDto addMessage(NewMessageDto newMessageDto);

    List<MessageDto> getMessagesByChatId(long chatId);

    MessageDto getMessageById(long messageId);

    void deleteMessageById(long messageId);
}
