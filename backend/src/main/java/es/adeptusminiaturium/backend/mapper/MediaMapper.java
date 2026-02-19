package es.adeptusminiaturium.backend.mapper;

import es.adeptusminiaturium.backend.dto.MediaDto;
import es.adeptusminiaturium.backend.model.Media;

import java.time.LocalDateTime;

public class MediaMapper {

    public static MediaDto.Response toResponse(Media entity) {
        MediaDto.Response dto = new MediaDto.Response();
        dto.setMediaId(entity.getMediaId());
        dto.setPost(PostMapper.toResponse(entity.getPost()));
        dto.setMediaType(entity.getMediaType());
        dto.setUrl(entity.getUrl());
        dto.setPosition(entity.getPosition());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public static Media toEntity(MediaDto.Request dto) {
        Media entity = new Media();
        entity.setMediaId(null); // autoincrement
        entity.setPost(null); // se setea después con repo.findById(dto.getPostId())
        entity.setMediaType(dto.getMediaType());
        entity.setUrl(dto.getUrl());
        entity.setPosition(dto.getPosition());
        entity.setCreatedAt(LocalDateTime.now());
        return entity;
    }
}