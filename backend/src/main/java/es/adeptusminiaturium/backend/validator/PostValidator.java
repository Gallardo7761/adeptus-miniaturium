package es.adeptusminiaturium.backend.validator;

import es.adeptusminiaturium.backend.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostValidator {

    public static List<String> validate(Post post) {
        List<String> errors = new ArrayList<>();

        if (post.getAuthor() == null) {
            errors.add("Post must have an author");
        }

        if (post.getTitle() == null || post.getTitle().isBlank()) {
            errors.add("Title cannot be empty");
        } else if (post.getTitle().length() > 255) {
            errors.add("Title too long");
        }

        if (post.getBody() != null && post.getBody().length() > 10000) {
            errors.add("Body too long");
        }

        if (post.getHashtags() != null && post.getHashtags().length() > 1000) {
            errors.add("Hashtags too long");
        }

        return errors;
    }

    public static void validateOrThrow(Post post) {
        List<String> errors = validate(post);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(", ", errors));
        }
    }
}