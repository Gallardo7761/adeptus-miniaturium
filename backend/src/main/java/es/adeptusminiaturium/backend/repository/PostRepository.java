package es.adeptusminiaturium.backend.repository;

import es.adeptusminiaturium.backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
