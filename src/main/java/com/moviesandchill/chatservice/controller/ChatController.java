package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.dto.MessageDto;
import com.moviesandchill.chatservice.entity.Chat;
import com.moviesandchill.chatservice.entity.Message;
import com.moviesandchill.chatservice.service.ChatService;
import com.moviesandchill.chatservice.service.MessageService;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    public ChatController(ChatService chatService, MessageService messageService, ModelMapper modelMapper) {
        this.chatService = chatService;
        this.messageService = messageService;
        this.modelMapper = modelMapper;
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

    @PostMapping("/{id}/messages")
    Message addMessage(@PathVariable("id") long chatId, @RequestBody MessageDto messageDto) {
        Message message = modelMapper.map(messageDto, Message.class);
        message.setChatId(chatId);
        return messageService.addMessage(message);
    }

}
