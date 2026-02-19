package es.adeptusminiaturium.backend.mapper;

import es.adeptusminiaturium.backend.dto.UserDto;
import es.adeptusminiaturium.backend.model.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserMapper {

    public static UserDto.Response toResponse(User entity) {
        UserDto.Response dto = new UserDto.Response();
        dto.setUserId(entity.getUserId());
        dto.setDisplayName(entity.getDisplayName());
        dto.setUserName(entity.getUserName());
        dto.setAvatar(entity.getAvatar());
        dto.setRole(entity.getRole());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public static User toEntity(UserDto.Request dto) {
        User entity = new User();
        entity.setUserId(UUID.randomUUID());
        entity.setDisplayName(dto.getDisplayName());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setAvatar(dto.getAvatar());
        entity.setRole(dto.getRole());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return entity;
    }
}
