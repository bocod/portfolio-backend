package com.portfolio.portofolio.security.jwt;

// import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.portfolio.portofolio.security.entity.MainUser;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;
// import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.*;


@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    // private Key getSigningKey() {
    //     byte[] keyBytes = Decoders.BASE64.decode(this.secret);
    //     return Keys.hmacShaKeyFor(keyBytes);
    // }

    public String generateToken(Authentication authentication) {
        MainUser mainUser = (MainUser) authentication.getPrincipal();
        List<String> roles = mainUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder().setSubject(mainUser.getUsername())
            .claim("roles", roles)
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime() + expiration * 1000))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
            // .signWith(getSigningKey())
    }


    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
            return true;
        } catch (MalformedJwtException e) {
            logger.error("malformed token");
        } catch (UnsupportedJwtException e) {
            logger.error("unsupported token");
        } catch (ExpiredJwtException e) {
            logger.error("expired token");
        } catch (IllegalArgumentException e) {
            logger.error("empty token");
        } catch (SignatureException e) {
            logger.error("fail in singature");
        };
        return false;
    }
}

// If update deprecated should be something like this;

    // public String getUsernameFromToken(String token) {
    //     return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody().getSubject();
    // }
    
    // public boolean validateToken(String token) {
    //     try {
    //         Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
    //         return true;
    //     } catch (MalformedJwtException e) {
    //         logger.error("malformed token");
    //     } catch (UnsupportedJwtException e) {
    //         logger.error("unsupported token");
    //     } catch (ExpiredJwtException e) {
    //         logger.error("expired token");
    //     } catch (IllegalArgumentException e) {
    //         logger.error("empty token");
    //     } catch (SignatureException e) {
    //         logger.error("fail in singature");
    //     };
    //     return false;
    // }