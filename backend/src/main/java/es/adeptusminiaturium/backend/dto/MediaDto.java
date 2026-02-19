package es.adeptusminiaturium.backend.dto;

import es.adeptusminiaturium.backend.enums.MediaType;

import java.time.LocalDateTime;

public class MediaDto {

    public static class Request {
        private Long postId;
        private MediaType mediaType;
        private String url;
        private Integer position;

        public Long getPostId() { return postId; }
        public void setPostId(Long postId) { this.postId = postId; }
        public MediaType getMediaType() { return mediaType; }
        public void setMediaType(MediaType mediaType) { this.mediaType = mediaType; }
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        public Integer getPosition() { return position; }
        public void setPosition(Integer position) { this.position = position; }
    }

    public static class Response {
        private Long mediaId;
        private PostDto.Response post;
        private MediaType mediaType;
        private String url;
        private Integer position;
        private LocalDateTime createdAt;

        public Long getMediaId() { return mediaId; }
        public void setMediaId(Long mediaId) { this.mediaId = mediaId; }
        public PostDto.Response getPost() { return post; }
        public void setPost(PostDto.Response post) { this.post = post; }
        public MediaType getMediaType() { return mediaType; }
        public void setMediaType(MediaType mediaType) { this.mediaType = mediaType; }
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        public Integer getPosition() { return position; }
        public void setPosition(Integer position) { this.position = position; }
        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    }
}
