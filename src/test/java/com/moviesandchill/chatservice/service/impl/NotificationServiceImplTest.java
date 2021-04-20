package com.moviesandchill.chatservice.service.impl;

import com.moviesandchill.chatservice.dto.notification.NewNotificationDto;
import com.moviesandchill.chatservice.repository.NotificationRepository;
import com.moviesandchill.chatservice.service.NotificationService;
import lombok.SneakyThrows;
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
class NotificationServiceImplTest {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private NotificationRepository notificationRepository;


    @AfterEach
    public void destruct() {
        notificationRepository.deleteAll();
    }

    @Test
    void getAllNotifications() {
        var newNotificationDto1 = new NewNotificationDto(1, "a");
        var newNotificationDto2 = new NewNotificationDto(2, "b");
        notificationService.addNotification(newNotificationDto1);
        notificationService.addNotification(newNotificationDto2);

        var notificationsDtos = notificationService.getAllNotifications();

        assertThat(notificationsDtos).hasSize(2);
    }


    @Test
    @SneakyThrows
    void addNotification() {
        var newNotificationDto = new NewNotificationDto(1, "a");

        var notificationDto = notificationService.addNotification(newNotificationDto);

        assertThat(notificationDto.getUserId()).isEqualTo(newNotificationDto.getUserId());
        assertThat(notificationDto.getText()).isEqualTo(newNotificationDto.getText());
    }

    @Test
    void deleteAllNotifications() {
        var newNotificationDto1 = new NewNotificationDto(1, "a");
        var newNotificationDto2 = new NewNotificationDto(2, "b");
        notificationService.addNotification(newNotificationDto1);
        notificationService.addNotification(newNotificationDto2);

        notificationService.deleteAllNotifications();

        var notificationsDtos = notificationService.getAllNotifications();
        assertThat(notificationsDtos).isEmpty();
    }

    @Test
    void getNotificationsByUserId() {
        var newNotificationDto1 = new NewNotificationDto(1, "a");
        var newNotificationDto2 = new NewNotificationDto(2, "b");
        var newNotificationDto3 = new NewNotificationDto(1, "c");
        notificationService.addNotification(newNotificationDto1);
        notificationService.addNotification(newNotificationDto2);
        notificationService.addNotification(newNotificationDto3);

        var notificationDtos = notificationService.getNotificationsByUserId(1);

        assertThat(notificationDtos).hasSize(2);
    }

    @Test
    void deleteNotificationsByUserId() {
        var newNotificationDto1 = new NewNotificationDto(1, "a");
        var newNotificationDto2 = new NewNotificationDto(2, "b");
        var newNotificationDto3 = new NewNotificationDto(1, "c");
        notificationService.addNotification(newNotificationDto1);
        notificationService.addNotification(newNotificationDto2);
        notificationService.addNotification(newNotificationDto3);

        notificationService.deleteNotificationsByUserId(1);
        var notificationDtos = notificationService.getNotificationsByUserId(1);

        assertThat(notificationDtos).isEmpty();
    }
}
