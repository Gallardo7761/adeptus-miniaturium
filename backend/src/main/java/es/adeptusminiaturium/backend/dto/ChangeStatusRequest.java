package es.adeptusminiaturium.backend.dto;

import es.adeptusminiaturium.backend.enums.UserStatus;

public record ChangeStatusRequest(UserStatus status) {}
