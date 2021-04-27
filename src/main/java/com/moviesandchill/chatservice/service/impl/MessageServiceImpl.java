package com.moviesandchill.chatservice.service.impl;

import com.moviesandchill.chatservice.dto.message.MessageDto;
import com.moviesandchill.chatservice.dto.message.NewMessageDto;
import com.moviesandchill.chatservice.mapper.MessageMapper;
import com.moviesandchill.chatservice.repository.ChatRepository;
import com.moviesandchill.chatservice.repository.MessageRepository;
import com.moviesandchill.chatservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private ChatRepository chatRepository;

    private MessageRepository messageRepository;

    private SimpMessagingTemplate simpMessagingTemplate;

    private MessageMapper messageMapper;

    @Override
    public List<MessageDto> getAllMessages() {
        var messages = messageRepository.findAll();
        return messageMapper.mapToDto(messages);
    }

    @Override
    public MessageDto addMessage(NewMessageDto newMessageDto) {
        var message = messageMapper.mapToEntity(newMessageDto);
        message = messageRepository.save(message);
        var messageDto = messageMapper.mapToDto(message);

        var chatId = message.getChatId();
        simpMessagingTemplate.convertAndSend("/topic/chats/" + chatId + "/messages", messageDto);
        return messageDto;
    }

    @Override
    public void deleteAllMessages() {
        messageRepository.deleteAll();
    }

    @Override
    public List<MessageDto> getAllMessagesByChatId(long chatId) {
        var messages = messageRepository.findAllByChatIdEquals(chatId);
        return messageMapper.mapToDto(messages);
    }

    @Override
    public void deleteAllMessagesByChatId(long chatId) {
        messageRepository.deleteAll();
    }

    @Override
    public MessageDto getMessageById(long messageId) {
        var message = messageRepository.getOne(messageId);
        return messageMapper.mapToDto(message);
    }

    @Override
    public void deleteMessageById(long messageId) {
        messageRepository.deleteByMessageIdEquals(messageId);
    }

    @Autowired
    public void setChatRepository(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Autowired
    public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Autowired
    public void setMessageMapper(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }
}
