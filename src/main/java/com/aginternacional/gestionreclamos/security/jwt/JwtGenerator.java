package com.aginternacional.gestionreclamos.security.jwt;

import com.aginternacional.gestionreclamos.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtGenerator {

    public String generate(User jwtUser) {


        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getLogin());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}
