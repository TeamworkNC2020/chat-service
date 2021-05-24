package com.moviesandchill.chatservice.service;

import com.moviesandchill.chatservice.dto.notification.NewNotificationDto;
import com.moviesandchill.chatservice.dto.notification.NotificationDto;

import java.util.List;

public interface NotificationService {
    List<NotificationDto> getAllNotifications();

    NotificationDto addNotification(NewNotificationDto newNotificationDto);

    void deleteAllNotifications();

    List<NotificationDto> getNotificationsByUserId(long userId);

    void deleteNotificationsByUserId(long userId);

    void deleteNotification(long notificationId);
}
