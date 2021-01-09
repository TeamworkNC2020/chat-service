package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.entity.Message;
import com.moviesandchill.chatservice.repository.MessageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(
        path = "api/messages",
        produces = "application/json"
)
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping()
    private List<Message> getAllMessages() {
        return messageRepository.findAll();
    }


}
