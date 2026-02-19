package es.adeptusminiaturium.backend.controller;

import es.adeptusminiaturium.backend.dto.MediaDto;
import es.adeptusminiaturium.backend.service.MediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    private final MediaService service;

    public MediaController(MediaService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<MediaDto.Response>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaDto.Response> getOne(@PathVariable Long id) {
        return ResponseEntity.ofNullable(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<MediaDto.Response> create(@RequestBody MediaDto.Request dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MediaDto.Response> update(@PathVariable Long id, @RequestBody MediaDto.Request dto) {
        return ResponseEntity.ofNullable(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}