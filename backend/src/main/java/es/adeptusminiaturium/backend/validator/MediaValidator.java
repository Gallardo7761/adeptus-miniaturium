package es.adeptusminiaturium.backend.validator;

import es.adeptusminiaturium.backend.model.Media;

import java.util.ArrayList;
import java.util.List;

public class MediaValidator {

    public static List<String> validate(Media media) {
        List<String> errors = new ArrayList<>();

        if (media.getPost() == null) {
            errors.add("Media must belong to a post");
        }

        if (media.getUrl() == null || media.getUrl().isBlank()) {
            errors.add("URL cannot be empty");
        } else if (media.getUrl().length() > 512) {
            errors.add("URL too long");
        }

        if (media.getPosition() == null || media.getPosition() < 0) {
            errors.add("Position cannot be negative");
        }

        return errors;
    }

    public static void validateOrThrow(Media media) {
        List<String> errors = validate(media);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(", ", errors));
        }
    }
}