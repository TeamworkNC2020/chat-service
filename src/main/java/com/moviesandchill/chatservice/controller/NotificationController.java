package com.moviesandchill.chatservice.controller;

import com.moviesandchill.chatservice.dto.notification.NewNotificationDto;
import com.moviesandchill.chatservice.dto.notification.NotificationDto;
import com.moviesandchill.chatservice.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(
        path = "api/v1/notifications",
        produces = "application/json"
)
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @GetMapping
    private List<NotificationDto> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @PostMapping
    private NotificationDto addNotification(@RequestBody NewNotificationDto newNotificationDto) {
        return notificationService.addNotification(newNotificationDto);
    }
}
