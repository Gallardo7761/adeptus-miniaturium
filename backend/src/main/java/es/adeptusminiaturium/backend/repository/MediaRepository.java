package es.adeptusminiaturium.backend.repository;

import es.adeptusminiaturium.backend.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findByPostPostId(Long postId);
}
