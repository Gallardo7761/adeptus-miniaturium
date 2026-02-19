package es.adeptusminiaturium.backend.mapper;

import es.adeptusminiaturium.backend.dto.PublicationDto;
import es.adeptusminiaturium.backend.model.Publication;

import java.time.LocalDateTime;

public class PublicationMapper {

    public static PublicationDto.Response toResponse(Publication entity) {
        PublicationDto.Response dto = new PublicationDto.Response();
        dto.setPublicationId(entity.getPublicationId());
        dto.setPost(PostMapper.toResponse(entity.getPost()));
        dto.setPlatform(entity.getPlatform());
        dto.setExternalId(entity.getExternalId());
        dto.setStatus(entity.getStatus());
        dto.setPublishedAt(entity.getPublishedAt());
        dto.setErrorMessage(entity.getErrorMessage());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public static Publication toEntity(PublicationDto.Request dto) {
        Publication entity = new Publication();
        entity.setPublicationId(null);
        entity.setPost(null);
        entity.setPlatform(dto.getPlatform());
        entity.setExternalId(dto.getExternalId());
        entity.setStatus(dto.getStatus());
        entity.setPublishedAt(null);
        entity.setErrorMessage(null);
        entity.setCreatedAt(LocalDateTime.now());
        return entity;
    }
}