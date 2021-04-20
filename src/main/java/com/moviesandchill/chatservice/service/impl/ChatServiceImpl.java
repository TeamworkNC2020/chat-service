package com.moviesandchill.chatservice.service.impl;

import com.moviesandchill.chatservice.dto.chat.ChatDto;
import com.moviesandchill.chatservice.dto.chat.NewChatDto;
import com.moviesandchill.chatservice.mapper.ChatMapper;
import com.moviesandchill.chatservice.repository.ChatRepository;
import com.moviesandchill.chatservice.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {

    private ChatRepository chatRepository;

    private SimpMessagingTemplate simpMessagingTemplate;

    private ChatMapper chatMapper;

    @Override
    public List<ChatDto> getAllChats() {
        var chats = chatRepository.findAll();
        return chatMapper.mapToDto(chats);
    }

    @Override
    public ChatDto addChat(NewChatDto newChatDto) {
        var chat = chatMapper.mapToEntity(newChatDto);
        chat = chatRepository.save(chat);
        return chatMapper.mapToDto(chat);
    }

    @Override
    public void deleteAllChats() {
        chatRepository.deleteAll();
    }

    @Override
    public ChatDto getChatById(long chatId) {
        var chat = chatRepository.findByChatId(chatId)
                .orElseThrow();

        return chatMapper.mapToDto(chat);
    }

    @Override
    public void deleteChatById(long chatId) {
        chatRepository.deleteByChatId(chatId);
    }

    @Autowired
    public void setChatRepository(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Autowired
    public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Autowired
    public void setChatMapper(ChatMapper chatMapper) {
        this.chatMapper = chatMapper;
    }
}
