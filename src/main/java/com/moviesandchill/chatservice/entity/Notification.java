package com.moviesandchill.chatservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationId;

    @Column(nullable = false)
    private long recipientId;

    @Column(nullable = false)
    private long senderId;

    @Column(nullable = false)
    private String senderName;

    @Column(nullable = false)
    private String text;

    private String pictureUrl;

    private String type;

    private String roomUrl;

    private String filmTitle;
}

