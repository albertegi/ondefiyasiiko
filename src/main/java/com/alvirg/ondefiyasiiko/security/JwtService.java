package com.alvirg.ondefiyasiiko.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {private static final String TOKEN_TYPE = "token_type";
    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    @Value("${spring.app.security.jwt.access-token-expiration}")
    private long accessTokenExpiration;

    @Value("${spring.app.security.jwt.refresh-token-expiration}")
    private long refreshTokenExpiration;

    public JwtService() throws Exception{
        this.privateKey = KeyUtils.loadPrivateKey("keys/local-only/private_key.pem");
        this.publicKey = KeyUtils.loadPublicKey("keys/local-only/public_key.pem");
    }

    public String generateAccessToken(final String username){
        final Map<String, Object> claims = Map.of(TOKEN_TYPE, "ACCESS_TOKEN");
        return buildToken(claims, username, this.accessTokenExpiration);
    }

    public String generateRefreshToken(final String username){
        final Map<String, Object> claims = Map.of(TOKEN_TYPE, "REFRESH_TOKEN");
        return buildToken(claims, username, this.refreshTokenExpiration);
    }

    private String buildToken(final Map<String, Object> claims,
                              final String username,
                              final long expiration) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(this.privateKey)
                .compact();
    }

    public boolean isTokenValid(final String token, final String expectedUsername){
        final String username = extractUsername(token); // extract the username from the token
        return username.equals(expectedUsername) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public String extractUsername(final String token) {
        return extractClaims(token).getSubject();
    }

    private Claims extractClaims(final String token) {

        try{
            return Jwts.parserBuilder()
                    .setSigningKey(this.publicKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (final Exception e) {
            throw new RuntimeException("Invalid JWT Token",e);
        }
    }

    public String refreshAccessToken(final String refreshToken){
        final Claims claims = extractClaims(refreshToken);
        if(!"REFRESH_TOKEN".equals(claims.get(TOKEN_TYPE))){
            throw new RuntimeException("invalid token type");
        }
        if(isTokenExpired(refreshToken)){
            throw new RuntimeException("Refresh Token expired");
        }
        final String username = claims.getSubject();
        return generateAccessToken(username);
    }
}
