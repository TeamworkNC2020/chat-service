package com.moviesandchill.chatservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chats")
@Data
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chatId;

    private String name;

    @ManyToMany
    @JoinColumn(
            name = "chat_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Participant> participants = new HashSet<>();

    @ManyToMany
    @JoinColumn(
            name = "chat_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Message> messages = new HashSet<>();
}
