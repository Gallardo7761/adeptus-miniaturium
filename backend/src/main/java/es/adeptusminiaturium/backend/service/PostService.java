package es.adeptusminiaturium.backend.service;

import es.adeptusminiaturium.backend.dto.PostDto;
import es.adeptusminiaturium.backend.mapper.PostMapper;
import es.adeptusminiaturium.backend.model.Post;
import es.adeptusminiaturium.backend.repository.PostRepository;
import es.adeptusminiaturium.backend.repository.UserRepository;
import es.adeptusminiaturium.backend.validator.PostValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public List<PostDto.Response> getAllPosts() {
        return postRepository.findAll().stream()
                .map(PostMapper::toResponse)
                .collect(Collectors.toList());
    }

    public PostDto.Response createPost(PostDto.Request dto) {
        Post post = PostMapper.toEntity(dto);
        post.setAuthor(userRepository.findById(dto.getAuthorId()).orElseThrow());
        Post saved = postRepository.save(post);
        return PostMapper.toResponse(saved);
    }

    public PostDto.Response getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        return PostMapper.toResponse(post);
    }
}