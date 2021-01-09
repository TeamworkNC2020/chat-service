package com.moviesandchill.chatservice.entity.pk;


import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ParticipantPK implements Serializable {
    private long chatId;

    private long userId;
}
