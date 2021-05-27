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
        var newNotificationDto1 = createNewInviteNotificationDto(1, 2, "first");
        var newNotificationDto2 = createNewFriendRequestNotificationDto(1, 2);
        notificationService.addNotification(newNotificationDto1);
        notificationService.addNotification(newNotificationDto2);

        var notificationsDtos = notificationService.getAllNotifications();

        assertThat(notificationsDtos).hasSize(2);
    }


    @Test
    @SneakyThrows
    void addNotification() {
        var newNotificationDto = createNewInviteNotificationDto(1, 1, "first");

        var notificationDto = notificationService.addNotification(newNotificationDto);

        assertThat(notificationDto.getRecipientId()).isEqualTo(newNotificationDto.getRecipientId());
        assertThat(notificationDto.getText()).isEqualTo(newNotificationDto.getText());
    }

    @Test
    void deleteAllNotifications() {
        var newNotificationDto1 = createNewInviteNotificationDto(1, 1, "first");
        var newNotificationDto2 = createNewFriendRequestNotificationDto(1, 1);
        notificationService.addNotification(newNotificationDto1);
        notificationService.addNotification(newNotificationDto2);

        notificationService.deleteAllNotifications();

        var notificationsDtos = notificationService.getAllNotifications();
        assertThat(notificationsDtos).isEmpty();
    }

    @Test
    void getNotificationsByUserId() {
        var newNotificationDto1 = createNewInviteNotificationDto(1, 2, "first");
        var newNotificationDto2 = createNewFriendRequestNotificationDto(1, 4);
        var newNotificationDto3 = createNewInviteNotificationDto(2, 3, "second");
        notificationService.addNotification(newNotificationDto1);
        notificationService.addNotification(newNotificationDto2);
        notificationService.addNotification(newNotificationDto3);

        var notificationDtos = notificationService.getNotificationsByUserId(1);

        assertThat(notificationDtos).hasSize(2);
    }

    @Test
    void deleteNotificationsByUserId() {
        var newNotificationDto1 = createNewInviteNotificationDto(1, 2, "first");
        var newNotificationDto2 = createNewFriendRequestNotificationDto(3, 4);
        var newNotificationDto3 = createNewInviteNotificationDto(3, 3, "second");
        notificationService.addNotification(newNotificationDto1);
        notificationService.addNotification(newNotificationDto2);
        notificationService.addNotification(newNotificationDto3);

        notificationService.deleteNotificationsByUserId(1);
        var notificationDtos = notificationService.getNotificationsByUserId(1);

        assertThat(notificationDtos).isEmpty();
    }

    private NewNotificationDto createNewFriendRequestNotificationDto(long recipientId, long senderId) {
        return NewNotificationDto.builder()
                .type("friend_request")
                .recipientId(recipientId)
                .senderId(senderId)
                .senderName("user with id " + senderId)
                .pictureUrl("/images/" + senderId)
                .text("user with " + senderId + " send friend request")
                .build();
    }

    private NewNotificationDto createNewInviteNotificationDto(long recipientId, long senderId, String roomTitle) {
        return NewNotificationDto.builder()
                .type("stream_invite")
                .recipientId(recipientId)
                .senderId(senderId)
                .senderName("user with id " + senderId)
                .pictureUrl("/images/" + senderId)
                .roomUrl("/films/" + roomTitle)
                .filmTitle(roomTitle)
                .text("user with " + senderId + " invite you to film " + roomTitle)
                .build();
    }
}
