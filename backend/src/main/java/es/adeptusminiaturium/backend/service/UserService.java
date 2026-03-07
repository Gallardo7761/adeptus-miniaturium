package es.adeptusminiaturium.backend.service;

import es.adeptusminiaturium.backend.dto.ChangePasswordRequest;
import es.adeptusminiaturium.backend.exception.NotFoundException;
import es.adeptusminiaturium.backend.model.User;
import es.adeptusminiaturium.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUser(UUID userId) {
        return repo.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return repo.save(user);
    }

    public User updateUser(UUID userId, User updatedUser) {
        return repo.findById(userId).map(user -> {

            user.setDisplayName(updatedUser.getDisplayName());
            user.setUserName(updatedUser.getUserName());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());
            user.setStatus(updatedUser.getStatus());
            user.setUpdatedAt(LocalDateTime.now());

            return repo.save(user);

        }).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void deleteUser(UUID userId) {
        repo.deleteById(userId);
    }

    public User getByUsername(String userName) {
        return repo.findByUserName(userName)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void changePassword(UUID userId, String password) {
        repo.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"))
                .setPassword(password);
    }
}