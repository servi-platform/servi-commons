package com.rosato.servicommons.util;

import com.rosato.servicommons.dto.JwtPayload;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class JwtUtil {
    private static final String SECRET_KEY = "tu_clave_secreta"; // Cambia esto por tu clave secreta

    public static String generateJwt(String subject, Long userId, String issuer, Long expirationTime) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
                .setSubject(subject)
                .claim("userId", userId)
                .setIssuer(issuer)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static JwtPayload verifyAndDecodeJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        JwtPayload jwtPayload = new JwtPayload();
        jwtPayload.setUserId(claims.get("userId", Long.class));
        jwtPayload.setUsername(claims.getSubject());
        jwtPayload.setRoles(claims.get("roles", Set.class));
        jwtPayload.setIssuer(claims.getIssuer());
        jwtPayload.setExpiration(claims.getExpiration().getTime());

        return jwtPayload;
    }
}