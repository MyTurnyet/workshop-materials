package com.workshop.auth;

import java.security.MessageDigest;

/**
 * Authentication service.
 * WARNING: Has security vulnerabilities - you'll find them in Challenge 4!
 */
public class AuthService {

    // SECURITY ISSUE: Hardcoded admin credentials
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    private final TokenService tokenService;

    public AuthService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public AuthResponse authenticate(String username, String password) {
        // SECURITY ISSUE: Weak password hashing
        String hashedPassword = weakHash(password);

        // Check credentials
        // SECURITY ISSUE: No rate limiting, allows brute force
        if (ADMIN_USERNAME.equals(username) && weakHash(ADMIN_PASSWORD).equals(hashedPassword)) {
            String token = tokenService.generateToken(username);
            return new AuthResponse(token, username, "ADMIN");
        }

        throw new AuthenticationException("Invalid credentials");
    }

    /**
     * SECURITY ISSUE: Using MD5 for password hashing (broken algorithm)
     */
    private String weakHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Hashing failed", e);
        }
    }
}

class AuthResponse {
    private String token;
    private String username;
    private String role;

    public AuthResponse(String token, String username, String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }

    public String getToken() { return token; }
    public String getUsername() { return username; }
    public String getRole() { return role; }
}

class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message) {
        super(message);
    }
}
