package com.moviesandchill.chatservice.service.impl;

import com.moviesandchill.chatservice.entity.Message;
import com.moviesandchill.chatservice.repository.MessageRepository;
import com.moviesandchill.chatservice.service.MessageService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> getMessageById(long messageId) {
        return messageRepository.findByMessageId(messageId);
    }

    @Override
    public List<Message> getMessagesByChatId(long chatId) {
        return messageRepository.findByChatId(chatId);
    }

    @Override
    public void deleteMessageById(long messageId) {
        messageRepository.deleteByMessageId(messageId);
    }
}
