package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.dto.chat.ChatDto;
import com.moviesandchill.chatservice.dto.chat.NewChatDto;
import com.moviesandchill.chatservice.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "api/v1/chats",
        produces = "application/json"
)
public class ChatController {

    private ChatService chatService;

    @GetMapping
    public List<ChatDto> getAllChats() {
        return chatService.getAllChats();
    }

    @PostMapping
    public ChatDto addChat(@RequestBody NewChatDto newChatDto) {
        return chatService.addChat(newChatDto);
    }

    @DeleteMapping
    public void deleteAllChats() {
        chatService.deleteAllChats();
    }

    @GetMapping("/{id}")
    public ChatDto getChatById(@PathVariable("id") long chatId) {
        return chatService.getChatById(chatId);
    }

    @DeleteMapping("/{id}")
    public void deleteChatById(@PathVariable("id") long chatId) {
        chatService.deleteChatById(chatId);
    }

    @Autowired
    public void setChatService(ChatService chatService) {
        this.chatService = chatService;
    }
}
