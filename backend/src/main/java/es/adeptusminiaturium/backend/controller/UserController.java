package es.adeptusminiaturium.backend.controller;

import es.adeptusminiaturium.backend.mapper.UserMapper;
import es.adeptusminiaturium.backend.model.User;
import es.adeptusminiaturium.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import es.adeptusminiaturium.backend.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserDto.Response>> getAll() {
        List<UserDto.Response> users = service.getAllUsers()
                .stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto.Response> getOne(@PathVariable UUID id) {
        User user = service.getUser(id);
        return ResponseEntity.ok(UserMapper.toResponse(user));
    }

    @PostMapping
    public ResponseEntity<UserDto.Response> create(@RequestBody UserDto.Request dto) {

        User user = UserMapper.toEntity(dto);
        User saved = service.createUser(user);

        return ResponseEntity.ok(UserMapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto.Response> update(
            @PathVariable UUID id,
            @RequestBody UserDto.Request dto) {

        User user = UserMapper.toEntity(dto);
        User updated = service.updateUser(id, user);

        return ResponseEntity.ok(UserMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}