package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.entity.Chat;
import com.moviesandchill.chatservice.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "api/v1/chats",
        produces = "application/json"
)
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping()
    private List<Chat> getAllChats() {
        return chatService.getAllChats();
    }

    @GetMapping("/{id}")
    private Chat getChatById(@PathVariable("id") long chatId) {
        return chatService.getChatById(chatId).orElseThrow();
    }

    @DeleteMapping("/{id}")
    private void deleteChatById(@PathVariable("id") long chatId) {
        chatService.deleteChatById(chatId);
    }
}