package es.adeptusminiaturium.backend.service;

import es.adeptusminiaturium.backend.dto.PublicationDto;
import es.adeptusminiaturium.backend.mapper.PublicationMapper;
import es.adeptusminiaturium.backend.model.Publication;
import es.adeptusminiaturium.backend.repository.PublicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService {

    private final PublicationRepository repo;

    public PublicationService(PublicationRepository repo) { this.repo = repo; }

    @Transactional
    public List<PublicationDto.Response> getAll() {
        return repo.findAll().stream().map(PublicationMapper::toResponse).collect(Collectors.toList());
    }

    public PublicationDto.Response getById(Long id) {
        return repo.findById(id).map(PublicationMapper::toResponse).orElse(null);
    }

    public PublicationDto.Response create(PublicationDto.Request dto) {
        Publication pub = PublicationMapper.toEntity(dto);
        return PublicationMapper.toResponse(repo.save(pub));
    }

    public PublicationDto.Response update(Long id, PublicationDto.Request dto) {
        return repo.findById(id).map(pub -> {
            pub.setPlatform(dto.getPlatform());
            pub.setExternalId(dto.getExternalId());
            pub.setStatus(dto.getStatus());
            return PublicationMapper.toResponse(repo.save(pub));
        }).orElse(null);
    }

    public void delete(Long id) { repo.deleteById(id); }
}