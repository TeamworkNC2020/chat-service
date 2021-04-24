package com.moviesandchill.chatservice.entity;

import com.moviesandchill.chatservice.entity.pk.ParticipantPK;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "participants")
@IdClass(ParticipantPK.class)
@Data
public class Participant {
    @Id
    private long chatId;

    @Id
    private long userId;

    private boolean isOwner;
}
