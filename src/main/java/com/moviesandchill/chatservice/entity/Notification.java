package com.moviesandchill.chatservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationId;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private String text;
}

