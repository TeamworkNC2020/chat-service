package com.moviesandchill.chatservice.mapper;

import com.moviesandchill.chatservice.dto.message.MessageDto;
import com.moviesandchill.chatservice.dto.message.NewMessageDto;
import com.moviesandchill.chatservice.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface MessageMapper {
    Message mapToEntity(NewMessageDto dto);

    Message mapToEntity(MessageDto dto);

    List<MessageDto> mapToDto(List<Message> entities);

    MessageDto mapToDto(Message entity);
}
