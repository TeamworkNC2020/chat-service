package com.moviesandchill.chatservice.mapper;

import com.moviesandchill.chatservice.dto.chat.ChatDto;
import com.moviesandchill.chatservice.dto.chat.NewChatDto;
import com.moviesandchill.chatservice.entity.Chat;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ChatMapper {
    Chat mapToEntity(NewChatDto dto);

    Chat mapToEntity(ChatDto dto);

    List<ChatDto> mapToDto(List<Chat> entities);

    ChatDto mapToDto(Chat entity);
}
