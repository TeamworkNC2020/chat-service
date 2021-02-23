package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.entity.Chat;
import com.moviesandchill.chatservice.entity.Message;
import com.moviesandchill.chatservice.service.ChatService;
import com.moviesandchill.chatservice.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "api/v1/chats",
        produces = "application/json"
)
public class ChatController {

    private final ChatService chatService;
    private final MessageService messageService;

    public ChatController(ChatService chatService, MessageService messageService) {
        this.chatService = chatService;
        this.messageService = messageService;
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

    @GetMapping("/{id}/messages")
    private List<Message> getMessagesByChatId(@PathVariable("id") long chatId) {
        return messageService.getMessagesByChatId(chatId);
    }

}
