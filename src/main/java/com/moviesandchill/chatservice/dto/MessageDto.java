package com.moviesandchill.chatservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private long chatId;
    private long userId;
    private String text;
}
