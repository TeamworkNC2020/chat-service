package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.dto.message.MessageDto;
import com.moviesandchill.chatservice.dto.message.NewMessageDto;
import com.moviesandchill.chatservice.entity.Chat;
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


    @GetMapping()
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }

    @GetMapping("/{id}")
    public Chat getChatById(@PathVariable("id") long chatId) {
        return chatService.getChatById(chatId).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteChatById(@PathVariable("id") long chatId) {
        chatService.deleteChatById(chatId);
    }

    @GetMapping("/{id}/messages")
    public List<MessageDto> getMessagesByChatId(@PathVariable("id") long chatId) {
        return messageService.getMessagesByChatId(chatId);
    }

    @PostMapping("/{id}/messages")
    public MessageDto addMessage(@PathVariable("id") long chatId, @RequestBody NewMessageDto newMessageDto) {
        newMessageDto.setChatId(chatId);
        return messageService.addMessage(newMessageDto);
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
