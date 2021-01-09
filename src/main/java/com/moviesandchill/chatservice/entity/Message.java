package com.moviesandchill.chatservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long messageId;

    private long chatId;

    private long userId;

    private String text;
}
