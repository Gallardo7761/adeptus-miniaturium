package es.adeptusminiaturium.backend.dto;

import es.adeptusminiaturium.backend.enums.PostStatus;

import java.time.LocalDateTime;

import java.time.LocalDateTime;
import java.util.UUID;

public class PostDto {

    public static class Request {
        private UUID authorId;
        private String title;
        private String body;
        private String hashtags;
        private PostStatus status;

        public UUID getAuthorId() { return authorId; }
        public void setAuthorId(UUID authorId) { this.authorId = authorId; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getBody() { return body; }
        public void setBody(String body) { this.body = body; }
        public String getHashtags() { return hashtags; }
        public void setHashtags(String hashtags) { this.hashtags = hashtags; }
        public PostStatus getStatus() { return status; }
        public void setStatus(PostStatus status) { this.status = status; }
    }

    public static class Response {
        private Long postId;
        private UserDto.Response author;
        private String title;
        private String body;
        private String hashtags;
        private PostStatus status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime publishedAt;

        public Long getPostId() { return postId; }
        public void setPostId(Long postId) { this.postId = postId; }
        public UserDto.Response getAuthor() { return author; }
        public void setAuthor(UserDto.Response author) { this.author = author; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getBody() { return body; }
        public void setBody(String body) { this.body = body; }
        public String getHashtags() { return hashtags; }
        public void setHashtags(String hashtags) { this.hashtags = hashtags; }
        public PostStatus getStatus() { return status; }
        public void setStatus(PostStatus status) { this.status = status; }
        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
        public LocalDateTime getUpdatedAt() { return updatedAt; }
        public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
        public LocalDateTime getPublishedAt() { return publishedAt; }
        public void setPublishedAt(LocalDateTime publishedAt) { this.publishedAt = publishedAt; }
    }
}
