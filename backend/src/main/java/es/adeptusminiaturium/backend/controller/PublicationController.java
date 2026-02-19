package es.adeptusminiaturium.backend.controller;

import es.adeptusminiaturium.backend.dto.PublicationDto;
import es.adeptusminiaturium.backend.service.PublicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    private final PublicationService service;

    public PublicationController(PublicationService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<PublicationDto.Response>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationDto.Response> getOne(@PathVariable Long id) {
        return ResponseEntity.ofNullable(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<PublicationDto.Response> create(@RequestBody PublicationDto.Request dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicationDto.Response> update(@PathVariable Long id, @RequestBody PublicationDto.Request dto) {
        return ResponseEntity.ofNullable(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}