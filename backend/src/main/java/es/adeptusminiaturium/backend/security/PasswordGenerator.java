package es.adeptusminiaturium.backend.security;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*"; // compatibles con bcrypt
    private static final String ALL = UPPER + LOWER + DIGITS + SYMBOLS;

    private static final SecureRandom random = new SecureRandom();

    public static String generate(int length) {
        if (length < 8) length = 8;

        List<Character> password = new ArrayList<>();

        password.add(getRandChar(UPPER));
        password.add(getRandChar(LOWER));
        password.add(getRandChar(DIGITS));
        password.add(getRandChar(SYMBOLS));

        while (password.size() < length) {
            password.add(getRandChar(ALL));
        }

        Collections.shuffle(password, random);

        StringBuilder sb = new StringBuilder();
        for (char c : password) {
            sb.append(c);
        }

        return sb.toString();
    }

    private static char getRandChar(String chars) {
        return chars.charAt(random.nextInt(chars.length()));
    }
}
