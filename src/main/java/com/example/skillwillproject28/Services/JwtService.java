package com.example.skillwillproject28.Services;

import com.example.skillwillproject28.Models.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private String secretKey = "ksjkdfjlksdjlfkjskldfjklsjdlkfjksjdf";

    public String generateToken(UserModel userModel)
    {

        return Jwts.builder()
                .claim("username",userModel.getUserName())
                .claim("role",userModel.getRole().toString())
                .claim("id",userModel.getId())
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
                .compact();
    }


    public Claims getAllClaims (String token)
    {
        Jws<Claims> claims = Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build().parseSignedClaims(token);
        Claims payload = claims.getPayload();
        return payload;

    }

    public boolean isExpriedToken(String token)
    {
        Date expiration = getAllClaims(token).getExpiration();
        return expiration.before(new Date(System.currentTimeMillis()));
    }
}
