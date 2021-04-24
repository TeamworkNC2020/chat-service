package com.moviesandchill.chatservice.service.impl;

import com.moviesandchill.chatservice.dto.chat.NewChatDto;
import com.moviesandchill.chatservice.dto.message.NewMessageDto;
import com.moviesandchill.chatservice.repository.ChatRepository;
import com.moviesandchill.chatservice.repository.MessageRepository;
import com.moviesandchill.chatservice.service.ChatService;
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
    private ChatService chatService;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatRepository chatRepository;

    @AfterEach
    public void destruct() {
        messageRepository.deleteAll();
        chatRepository.deleteAll();
    }

    @Test
    void getAllMessages() {
        var chatDto1 = chatService.addChat(new NewChatDto("chat"));
        var newMessageDto1 = new NewMessageDto(chatDto1.getChatId(), 1, "a");
        var newMessageDto2 = new NewMessageDto(chatDto1.getChatId(), 2, "b");
        var newMessageDto3 = new NewMessageDto(chatDto1.getChatId(), 1, "c");
        messageService.addMessage(newMessageDto1);
        messageService.addMessage(newMessageDto2);
        messageService.addMessage(newMessageDto3);

        var messageDtos = messageService.getAllMessages();

        assertThat(messageDtos).hasSize(3);
    }

    @Test
    void deleteAllMessages() {
        var chatDto1 = chatService.addChat(new NewChatDto("chat"));
        var newMessageDto1 = new NewMessageDto(chatDto1.getChatId(), 1, "a");
        var newMessageDto2 = new NewMessageDto(chatDto1.getChatId(), 2, "b");
        var newMessageDto3 = new NewMessageDto(chatDto1.getChatId(), 1, "c");
        messageService.addMessage(newMessageDto1);
        messageService.addMessage(newMessageDto2);
        messageService.addMessage(newMessageDto3);

        messageService.deleteAllMessages();

        var messageDtos = messageService.getAllMessages();
        assertThat(messageDtos).isEmpty();
    }

    @Test
    void addMessage() {
        var chatDto1 = chatService.addChat(new NewChatDto("chat"));
        var newMessageDto1 = new NewMessageDto(chatDto1.getChatId(), 1, "a");

        var messageDto = messageService.addMessage(newMessageDto1);


        assertThat(messageDto.getText()).isEqualTo(messageDto.getText());
    }

    @Test
    void getMessagesByChatId() {
        var chatDto1 = chatService.addChat(new NewChatDto("chat 1"));
        var chatDto2 = chatService.addChat(new NewChatDto("chat 2"));
        var newMessageDto1 = new NewMessageDto(chatDto1.getChatId(), 1, "a");
        var newMessageDto2 = new NewMessageDto(chatDto1.getChatId(), 2, "b");
        var newMessageDto3 = new NewMessageDto(chatDto2.getChatId(), 1, "c");
        var newMessageDto4 = new NewMessageDto(chatDto2.getChatId(), 3, "d");
        messageService.addMessage(newMessageDto1);
        messageService.addMessage(newMessageDto2);
        messageService.addMessage(newMessageDto3);
        messageService.addMessage(newMessageDto4);

        var messages = messageService.getAllMessagesByChatId(chatDto1.getChatId());

        assertThat(messages).hasSize(2);
    }

    @Test
    void getMessageById() {
    }

    @Test
    void deleteMessageById() {

    }
}
