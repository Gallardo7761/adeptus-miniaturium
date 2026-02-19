package es.adeptusminiaturium.backend.enums;

import java.util.List;

public enum Platform {
    WEB,        // 0
    INSTAGRAM,  // 1
    TIKTOK,     // 2
    TWITTER;     // 3

    public static List<Platform> valuesList() {
        return List.of(values());
    }
}