package com.moviesandchill.chatservice.service.impl;

import com.moviesandchill.chatservice.dto.message.NewMessageDto;
import com.moviesandchill.chatservice.repository.MessageRepository;
import com.moviesandchill.chatservice.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Slf4j
class MessageServiceImplTest {

    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageRepository messageRepository;

    @AfterEach
    public void destruct() {
        messageRepository.deleteAll();
    }

    @Test
    void getAllMessages() {
        var newMessageDto1 = new NewMessageDto(1, 1, "a");
        var newMessageDto2 = new NewMessageDto(1, 2, "b");
        var newMessageDto3 = new NewMessageDto(1, 1, "c");
        messageService.addMessage(newMessageDto1);
        messageService.addMessage(newMessageDto2);
        messageService.addMessage(newMessageDto3);

        var messageDtos = messageService.getAllMessages();

        assertThat(messageDtos).hasSize(3);
    }

    @Test
    void addMessage() {
        var newMessageDto1 = new NewMessageDto(1, 1, "a");

        var messageDto = messageService.addMessage(newMessageDto1);

        assertThat(messageDto.getUserId()).isEqualTo(messageDto.getUserId());
        assertThat(messageDto.getText()).isEqualTo(messageDto.getText());
    }

    @Test
    void getMessagesByChatId() {

    }

    @Test
    void getMessageById() {
    }

    @Test
    void deleteMessageById() {

    }
}
