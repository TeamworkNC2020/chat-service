package com.moviesandchill.chatservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "attachments")
@Data
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long attachmentId;

    private long messageId;

    private String type;

    private String content;
}

