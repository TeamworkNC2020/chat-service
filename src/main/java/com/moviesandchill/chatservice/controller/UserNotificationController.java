package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.dto.notification.NotificationDto;
import com.moviesandchill.chatservice.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "api/v1/users/{userId}/notifications",
        produces = "application/json"
)
public class UserNotificationController {
    private final NotificationService notificationService;

    public UserNotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    private List<NotificationDto> getNotificationsByUserId(@PathVariable long userId) {
        return notificationService.getNotificationsByUserId(userId);
    }

    @DeleteMapping
    private void deleteNotificationsByUserId(@PathVariable long userId) {
        notificationService.deleteNotificationsByUserId(userId);
    }

}
