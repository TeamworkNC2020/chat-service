package com.moviesandchill.chatservice.mapper;

import com.moviesandchill.chatservice.dto.notification.NewNotificationDto;
import com.moviesandchill.chatservice.dto.notification.NotificationDto;
import com.moviesandchill.chatservice.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface NotificationMapper {
    Notification mapToEntity(NewNotificationDto dto);

    Notification mapToEntity(Long filmId);

    List<NotificationDto> mapToDto(List<Notification> entities);

    NotificationDto mapToDto(Notification entity);
}
