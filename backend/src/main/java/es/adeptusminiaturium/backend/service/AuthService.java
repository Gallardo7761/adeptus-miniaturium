package es.adeptusminiaturium.backend.service;

import es.adeptusminiaturium.backend.dto.ChangePasswordRequest;
import es.adeptusminiaturium.backend.dto.LoginRequest;
import es.adeptusminiaturium.backend.dto.LoginResponse;
import es.adeptusminiaturium.backend.dto.UserDto;
import es.adeptusminiaturium.backend.enums.UserStatus;
import es.adeptusminiaturium.backend.exception.ForbiddenException;
import es.adeptusminiaturium.backend.exception.UnauthorizedException;
import es.adeptusminiaturium.backend.exception.ValidationException;
import es.adeptusminiaturium.backend.mapper.UserMapper;
import es.adeptusminiaturium.backend.model.User;
import es.adeptusminiaturium.backend.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserService userService, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest request) {
        User user = userService.getByUsername(request.userName());

        if (!passwordEncoder.matches(request.password(), user.getPassword()))
            throw new UnauthorizedException("Invalid credentials");

        if (user.getStatus() == UserStatus.INACTIVE)
            throw new ForbiddenException("User is inactive");

        String token = jwtService.generateToken(user.getUserId());
        UserDto.Response userDto = UserMapper.toResponse(user);

        return new LoginResponse(token, userDto);
    }

    public void changePassword(UUID userId, ChangePasswordRequest request) {
        User user = userService.getUser(userId);

        if (!passwordEncoder.matches(request.oldPassword(), user.getPassword())) {
            throw new ValidationException("oldPassword", "La contraseña actual es incorrecta");
        }

        if (request.newPassword().length() < 8) {
            throw new ValidationException("newPassword", "La nueva contraseña debe tener al menos 8 caracteres");
        }

        userService.changePassword(userId, request.newPassword());
    }
}
