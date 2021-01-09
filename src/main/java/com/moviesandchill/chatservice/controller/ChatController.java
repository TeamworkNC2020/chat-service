package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.entity.Chat;
import com.moviesandchill.chatservice.repository.ChatRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(
        path = "api/chats",
        produces = "application/json"
)
public class ChatController {

    private final ChatRepository chatRepository;

    public ChatController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @GetMapping()
    private List<Chat> getAllChats() {
        return chatRepository.findAll();
    }
}
