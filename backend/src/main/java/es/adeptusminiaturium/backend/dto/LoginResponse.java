package es.adeptusminiaturium.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponse(@JsonProperty("token") String token,
							UserDto.Response user) {}