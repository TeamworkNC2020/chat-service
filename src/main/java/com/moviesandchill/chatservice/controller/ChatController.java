package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.dto.chat.ChatDto;
import com.moviesandchill.chatservice.dto.chat.NewChatDto;
import com.moviesandchill.chatservice.dto.message.MessageDto;
import com.moviesandchill.chatservice.service.ChatService;
import com.moviesandchill.chatservice.service.MessageService;
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
    private MessageService messageService;

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

    @GetMapping("/{id}/messages")
    List<MessageDto> getAllMessagesByChatId(@PathVariable("id") long chatId) {
        return messageService.getAllMessagesByChatId(chatId);
    }

    @DeleteMapping("/{id}/messages")
    void deleteAllMessagesByChatId(@PathVariable("id") long chatId) {
        messageService.deleteAllMessagesByChatId(chatId);
    }

    @Autowired
    public void setChatService(ChatService chatService) {
        this.chatService = chatService;
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
