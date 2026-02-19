package es.adeptusminiaturium.backend.validator;

import es.adeptusminiaturium.backend.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(User user) {
        List<String> errors = new ArrayList<>();

        if (user.getUserName() == null || user.getUserName().isBlank()) {
            errors.add("Username cannot be empty");
        }

        if (user.getPassword() == null || user.getPassword().length() < 8) {
            errors.add("Password must have at least 8 characters");
        }

        if (user.getDisplayName() != null && user.getDisplayName().length() > 255) {
            errors.add("DisplayName too long");
        }

        if (user.getAvatar() != null && user.getAvatar().length() > 255) {
            errors.add("Avatar URL too long");
        }

        return errors;
    }

    public static void validateOrThrow(User user) {
        List<String> errors = validate(user);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(", ", errors));
        }
    }
}