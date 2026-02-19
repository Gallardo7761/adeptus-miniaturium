package es.adeptusminiaturium.backend.repository;

import es.adeptusminiaturium.backend.model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByPostPostId(Long postId);
}
