package es.adeptusminiaturium.backend.controller;

import es.adeptusminiaturium.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import es.adeptusminiaturium.backend.dto.UserDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<UserDto.Response>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto.Response> getOne(@PathVariable UUID id) {
        return ResponseEntity.ofNullable(service.getUser(id));
    }

    @PostMapping
    public ResponseEntity<UserDto.Response> create(@RequestBody UserDto.Request dto) {
        return ResponseEntity.ok(service.createUser(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto.Response> update(@PathVariable UUID id, @RequestBody UserDto.Request dto) {
        return ResponseEntity.ofNullable(service.updateUser(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}