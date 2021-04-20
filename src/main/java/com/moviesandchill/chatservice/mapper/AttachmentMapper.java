package com.moviesandchill.chatservice.mapper;

import com.moviesandchill.chatservice.dto.attachment.AttachmentDto;
import com.moviesandchill.chatservice.dto.attachment.NewAttachmentDto;
import com.moviesandchill.chatservice.entity.Attachment;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface AttachmentMapper {
    Attachment mapToEntity(NewAttachmentDto dto);

    Attachment mapToEntity(AttachmentDto attachmentDto);

    List<AttachmentDto> mapToDto(List<Attachment> entities);

    AttachmentDto mapToDto(Attachment entity);
}
