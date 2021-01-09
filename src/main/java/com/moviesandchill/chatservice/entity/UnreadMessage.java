package com.moviesandchill.chatservice.entity;

import com.moviesandchill.chatservice.entity.pk.UnreadMessagePK;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "unread_messages")
@Data
public class UnreadMessage {
    @EmbeddedId
    private UnreadMessagePK unreadMessagePK;
}
