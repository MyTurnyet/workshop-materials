package com.workshop.auth;

import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * JWT token service.
 * WARNING: Has security issues - you'll find them in Challenge 4!
 */
public class TokenService {

    // SECURITY ISSUE: Hardcoded JWT secret
    private static final String JWT_SECRET = "mySecretKey123";

    // SECURITY ISSUE: In-memory blacklist has memory leak (no cleanup)
    private final Set<String> blacklistedTokens = new HashSet<>();

    public String generateToken(String username) {
        long expirationTime = System.currentTimeMillis() + 3600000; // 1 hour
        String payload = username + ":" + expirationTime;

        // SECURITY ISSUE: Weak token generation (not actual JWT)
        String token = Base64.getEncoder().encodeToString(payload.getBytes());
        return token + "." + sign(token);
    }

    public boolean validateToken(String token) {
        // SECURITY ISSUE: No null check
        if (blacklistedTokens.contains(token)) {
            return false;
        }

        // Extract and verify signature
        String[] parts = token.split("\\.");
        if (parts.length != 2) {
            return false;
        }

        String payload = parts[0];
        String signature = parts[1];

        if (!sign(payload).equals(signature)) {
            return false;
        }

        // Check expiration
        String decoded = new String(Base64.getDecoder().decode(payload));
        String[] data = decoded.split(":");
        long expirationTime = Long.parseLong(data[1]);

        return System.currentTimeMillis() < expirationTime;
    }

    public void invalidateToken(String token) {
        // SECURITY ISSUE: No cleanup, memory grows indefinitely
        blacklistedTokens.add(token);
    }

    public String extractUsername(String token) {
        String[] parts = token.split("\\.");
        String payload = parts[0];
        String decoded = new String(Base64.getDecoder().decode(payload));
        return decoded.split(":")[0];
    }

    /**
     * SECURITY ISSUE: Weak signing mechanism
     */
    private String sign(String data) {
        return Base64.getEncoder().encodeToString((data + JWT_SECRET).getBytes());
    }
}
