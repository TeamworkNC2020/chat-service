package com.moviesandchill.chatservice.entity.pk;


import lombok.Data;

import java.io.Serializable;

@Data
public class ParticipantPK implements Serializable {
    private long chatId;

    private long userId;
}
