package es.adeptusminiaturium.backend.service;


import es.adeptusminiaturium.backend.dto.UserDto;
import es.adeptusminiaturium.backend.mapper.UserMapper;
import es.adeptusminiaturium.backend.model.User;
import es.adeptusminiaturium.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) { this.repo = repo; }

    public List<UserDto.Response> getAllUsers() {
        return repo.findAll().stream().map(UserMapper::toResponse).collect(Collectors.toList());
    }

    public UserDto.Response getUser(UUID userId) {
        return repo.findById(userId).map(UserMapper::toResponse).orElse(null);
    }

    public UserDto.Response createUser(UserDto.Request dto) {
        User user = UserMapper.toEntity(dto);
        return UserMapper.toResponse(repo.save(user));
    }

    public UserDto.Response updateUser(UUID userId, UserDto.Request dto) {
        return repo.findById(userId).map(user -> {
            user.setDisplayName(dto.getDisplayName());
            user.setUserName(dto.getUserName());
            user.setPassword(dto.getPassword());
            user.setRole(dto.getRole());
            user.setStatus(dto.getStatus());
            user.setUpdatedAt(LocalDateTime.now());
            return UserMapper.toResponse(repo.save(user));
        }).orElse(null);
    }

    public void deleteUser(UUID userId) { repo.deleteById(userId); }
}