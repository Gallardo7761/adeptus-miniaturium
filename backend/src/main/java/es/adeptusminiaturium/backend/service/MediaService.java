package es.adeptusminiaturium.backend.service;

import es.adeptusminiaturium.backend.dto.MediaDto;
import es.adeptusminiaturium.backend.mapper.MediaMapper;
import es.adeptusminiaturium.backend.model.Media;
import es.adeptusminiaturium.backend.repository.MediaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaService {

    private final MediaRepository repo;

    public MediaService(MediaRepository repo) { this.repo = repo; }

    @Transactional
    public List<MediaDto.Response> getAll() {
        return repo.findAll().stream().map(MediaMapper::toResponse).collect(Collectors.toList());
    }

    public MediaDto.Response getById(Long id) {
        return repo.findById(id).map(MediaMapper::toResponse).orElse(null);
    }

    public MediaDto.Response create(MediaDto.Request dto) {
        Media media = MediaMapper.toEntity(dto);
        return MediaMapper.toResponse(repo.save(media));
    }

    public MediaDto.Response update(Long id, MediaDto.Request dto) {
        return repo.findById(id).map(media -> {
            media.setMediaType(dto.getMediaType());
            media.setUrl(dto.getUrl());
            media.setPosition(dto.getPosition());
            return MediaMapper.toResponse(repo.save(media));
        }).orElse(null);
    }

    public void delete(Long id) { repo.deleteById(id); }
}