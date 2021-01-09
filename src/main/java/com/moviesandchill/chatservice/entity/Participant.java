package com.moviesandchill.chatservice.entity;

import com.moviesandchill.chatservice.entity.pk.ParticipantPK;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "participants")
@Data
public class Participant {
    @EmbeddedId
    private ParticipantPK participantPK;

    private boolean isOwner;
}
