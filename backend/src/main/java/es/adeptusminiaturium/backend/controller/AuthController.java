package es.adeptusminiaturium.backend.controller;

import es.adeptusminiaturium.backend.dto.ApiErrorDto;
import es.adeptusminiaturium.backend.dto.ChangePasswordRequest;
import es.adeptusminiaturium.backend.dto.LoginRequest;
import es.adeptusminiaturium.backend.dto.LoginResponse;
import es.adeptusminiaturium.backend.security.JwtService;
import es.adeptusminiaturium.backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
    private final AuthService authService;

    public AuthController(JwtService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(
                new LoginResponse(response.token(), response.user())
        );
    }

    @GetMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body(
                    new ApiErrorDto(
                            401,
                            "Unauthorized",
                            "No token",
                            "/api/auth/change-password"
                    )
            );
        }

        String token = authHeader.substring(7);
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401).body(
                    new ApiErrorDto(
                            401,
                            "Unauthorized",
                            "Invalid token",
                            "/api/auth/change-password"
                    )
            );
        }

        UUID userId = jwtService.getUserId(token);
        String newToken = jwtService.generateToken(userId);

        return ResponseEntity.ok(Map.of(
                "token", newToken,
                "userId", userId
        ));
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody ChangePasswordRequest request
    ) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body(
                    new ApiErrorDto(
                            401,
                            "Unauthorized",
                            "No hay token",
                            "/api/auth/change-password"
                    )
            );
        }

        String token = authHeader.substring(7);
        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(401).body(
                    new ApiErrorDto(
                            401,
                            "Unauthorized",
                            "Invalid token",
                            "/api/auth/change-password"
                    )
            );
        }

        UUID userId = jwtService.getUserId(token);

        authService.changePassword(userId, request);
        return ResponseEntity.ok(Map.of("message", "Contraseña cambiada correctamente"));
    }


    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        return ResponseEntity.ok(jwtService.validateToken(token));
    }
}
