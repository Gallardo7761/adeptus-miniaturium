package es.adeptusminiaturium.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChangePasswordRequest(@NotBlank String oldPassword,
									@NotBlank String newPassword) {}

