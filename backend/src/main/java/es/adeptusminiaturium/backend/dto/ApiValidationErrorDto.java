package es.adeptusminiaturium.backend.dto;

import tools.jackson.databind.ObjectMapper;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class ApiValidationErrorDto {
    private int status;
    private Map<String,String> errors;
    private String path;
    private Instant timestamp;

    public ApiValidationErrorDto(Map<String,String> errors, String path) {
        this.status = 422;
        this.errors = errors;
        this.path = path;
        this.timestamp = Instant.now();
    }

    public Map<String,String> getErrors() {
        return errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setErrors(Map<String,String> errors) {
        this.errors = errors;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String toJson() {
        return new ObjectMapper().writeValueAsString(this);
    }
}
