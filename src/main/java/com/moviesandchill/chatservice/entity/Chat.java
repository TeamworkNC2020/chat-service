package com.moviesandchill.chatservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "chats")
@Data
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long chatId;

    private String name;
}
