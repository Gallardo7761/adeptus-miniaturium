package es.adeptusminiaturium.backend.dto;

import es.adeptusminiaturium.backend.enums.Platform;
import es.adeptusminiaturium.backend.enums.PublicationStatus;

import java.time.LocalDateTime;

public class PublicationDto {

    public static class Request {
        private Long postId;
        private Platform platform;
        private String externalId;
        private PublicationStatus status;

        // getters y setters
        public Long getPostId() { return postId; }
        public void setPostId(Long postId) { this.postId = postId; }
        public Platform getPlatform() { return platform; }
        public void setPlatform(Platform platform) { this.platform = platform; }
        public String getExternalId() { return externalId; }
        public void setExternalId(String externalId) { this.externalId = externalId; }
        public PublicationStatus getStatus() { return status; }
        public void setStatus(PublicationStatus status) { this.status = status; }
    }

    public static class Response {
        private Long publicationId;
        private PostDto.Response post;
        private Platform platform;
        private String externalId;
        private PublicationStatus status;
        private LocalDateTime publishedAt;
        private String errorMessage;
        private LocalDateTime createdAt;

        // getters y setters
        public Long getPublicationId() { return publicationId; }
        public void setPublicationId(Long publicationId) { this.publicationId = publicationId; }
        public PostDto.Response getPost() { return post; }
        public void setPost(PostDto.Response post) { this.post = post; }
        public Platform getPlatform() { return platform; }
        public void setPlatform(Platform platform) { this.platform = platform; }
        public String getExternalId() { return externalId; }
        public void setExternalId(String externalId) { this.externalId = externalId; }
        public PublicationStatus getStatus() { return status; }
        public void setStatus(PublicationStatus status) { this.status = status; }
        public LocalDateTime getPublishedAt() { return publishedAt; }
        public void setPublishedAt(LocalDateTime publishedAt) { this.publishedAt = publishedAt; }
        public String getErrorMessage() { return errorMessage; }
        public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    }
}