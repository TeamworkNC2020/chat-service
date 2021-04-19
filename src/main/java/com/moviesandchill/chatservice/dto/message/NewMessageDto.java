package com.moviesandchill.chatservice.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewMessageDto {
    private long chatId;

    private long userId;

    private String text;
}
