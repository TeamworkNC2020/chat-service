package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.dto.message.MessageDto;
import com.moviesandchill.chatservice.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "api/v1/messages",
        produces = "application/json"
)
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    private List<MessageDto> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    private MessageDto getMessageById(@PathVariable("id") long messageId) {
        return messageService.getMessageById(messageId);
    }

    @DeleteMapping("/{id}")
    private void deleteMessageById(@PathVariable("id") long messageId) {
        messageService.deleteMessageById(messageId);
    }
}
