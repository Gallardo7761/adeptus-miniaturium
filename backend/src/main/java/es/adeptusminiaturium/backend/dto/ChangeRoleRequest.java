package es.adeptusminiaturium.backend.dto;

import es.adeptusminiaturium.backend.enums.UserRole;

public record ChangeRoleRequest(UserRole role) {
}
