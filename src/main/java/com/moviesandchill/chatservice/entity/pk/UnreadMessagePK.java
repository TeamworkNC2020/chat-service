package com.moviesandchill.chatservice.entity.pk;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class UnreadMessagePK implements Serializable {
    private long message_id;

    private long userId;
}
