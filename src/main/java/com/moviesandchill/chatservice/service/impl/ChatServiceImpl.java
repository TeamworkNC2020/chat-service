package com.moviesandchill.chatservice.service.impl;

import com.moviesandchill.chatservice.entity.Chat;
import com.moviesandchill.chatservice.repository.ChatRepository;
import com.moviesandchill.chatservice.service.ChatService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    @Override
    public Optional<Chat> getChatById(long chatId) {
        return chatRepository.findByChatId(chatId);
    }

    @Override
    public void deleteChatById(long chatId) {
        chatRepository.deleteByChatId(chatId);
    }
}
