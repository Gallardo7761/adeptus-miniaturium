package es.adeptusminiaturium.backend.mapper;

import es.adeptusminiaturium.backend.dto.PostDto;
import es.adeptusminiaturium.backend.dto.UserDto;
import es.adeptusminiaturium.backend.model.Post;

import java.time.Instant;
import java.time.LocalDateTime;

public class PostMapper {

    public static PostDto.Response toResponse(Post entity) {
        PostDto.Response dto = new PostDto.Response();
        dto.setPostId(entity.getPostId());
        dto.setAuthor(UserMapper.toResponse(entity.getAuthor()));
        dto.setTitle(entity.getTitle());
        dto.setBody(entity.getBody());
        dto.setHashtags(entity.getHashtags());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setPublishedAt(entity.getPublishedAt());
        return dto;
    }

    public static Post toEntity(PostDto.Request dto) {
        Post entity = new Post();
        entity.setPostId(null);
        entity.setAuthor(null);
        entity.setTitle(dto.getTitle());
        entity.setBody(dto.getBody());
        entity.setHashtags(dto.getHashtags());
        entity.setStatus(dto.getStatus());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setPublishedAt(null);
        return entity;
    }
}