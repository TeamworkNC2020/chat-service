package com.moviesandchill.chatservice.dto.attachment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewAttachmentDto {
    private long messageId;

    private String type;

    private String content;
}
