package com.moviesandchill.chatservice.repository;

import com.moviesandchill.chatservice.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> getAllByRecipientId(long userId);

    List<Notification> deleteAllByRecipientId(long userId);
}
