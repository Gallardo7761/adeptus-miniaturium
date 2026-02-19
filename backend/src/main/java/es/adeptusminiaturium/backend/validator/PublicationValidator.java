package es.adeptusminiaturium.backend.validator;

import es.adeptusminiaturium.backend.enums.Platform;
import es.adeptusminiaturium.backend.model.Publication;

import java.util.ArrayList;
import java.util.List;

public class PublicationValidator {

    public static List<String> validate(Publication pub) {
        List<String> errors = new ArrayList<>();

        if (pub.getPost() == null) {
            errors.add("Publication must belong to a post");
        }

        if (pub.getPlatform() == null) {
            errors.add("Platform cannot be null");
        } else if (!Platform.valuesList().contains(pub.getPlatform())) {
            errors.add("Invalid platform");
        }

        if (pub.getStatus() == null) {
            errors.add("Status cannot be null");
        }

        if (pub.getExternalId() != null && pub.getExternalId().length() > 255) {
            errors.add("ExternalId too long");
        }

        if (pub.getErrorMessage() != null && pub.getErrorMessage().length() > 1000) {
            errors.add("ErrorMessage too long");
        }

        return errors;
    }

    public static void validateOrThrow(Publication pub) {
        List<String> errors = validate(pub);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(", ", errors));
        }
    }
}