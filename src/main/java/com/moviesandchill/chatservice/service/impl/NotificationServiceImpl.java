package com.moviesandchill.chatservice.service.impl;

import com.moviesandchill.chatservice.dto.notification.NewNotificationDto;
import com.moviesandchill.chatservice.dto.notification.NotificationDto;
import com.moviesandchill.chatservice.entity.Notification;
import com.moviesandchill.chatservice.mapper.NotificationMapper;
import com.moviesandchill.chatservice.repository.NotificationRepository;
import com.moviesandchill.chatservice.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    private NotificationRepository notificationRepository;

    private SimpMessagingTemplate simpMessagingTemplate;

    private NotificationMapper notificationMapper;

    @Override
    public List<NotificationDto> getAllNotifications() {
        var users = notificationRepository.findAll();
        return notificationMapper.mapToDto(users);
    }

    @Override
    public NotificationDto addNotification(NewNotificationDto newNotificationDto) {
        var notification = notificationMapper.mapToEntity(newNotificationDto);
        notification = notificationRepository.save(notification);
        var notificationDto = notificationMapper.mapToDto(notification);

        var userId = notification.getRecipientId();

        simpMessagingTemplate.convertAndSend("/topic/users/" + userId + "/notifications", notificationDto);
        return notificationDto;
    }

    @Override
    public void deleteAllNotifications() {
        notificationRepository.deleteAll();
    }

    @Override
    public List<NotificationDto> getNotificationsByUserId(long userId) {
        List<Notification> notifications = notificationRepository.getAllByRecipientId(userId);
        return notificationMapper.mapToDto(notifications);
    }

    @Override
    public void deleteNotificationsByUserId(long userId) {
        notificationRepository.deleteAllByRecipientId(userId);
    }

    @Override
    public void deleteNotification(long notificationId) {
        notificationRepository.deleteById(notificationId);
    }

    @Autowired
    public void setNotificationRepository(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Autowired
    public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Autowired
    public void setNotificationMapper(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }
}
