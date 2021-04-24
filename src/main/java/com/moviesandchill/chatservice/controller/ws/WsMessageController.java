package com.moviesandchill.chatservice.controller.ws;

import com.moviesandchill.chatservice.dto.message.NewMessageDto;
import com.moviesandchill.chatservice.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class WsMessageController {

    private final MessageService messageService;

    public WsMessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("messages/send")
    void addMessage(@Payload NewMessageDto newMessageDto) {
        log.info(String.valueOf(newMessageDto));
        messageService.addMessage(newMessageDto);
    }
}
