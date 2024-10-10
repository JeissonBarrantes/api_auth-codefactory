package com.authb.api_auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    public static final String SECRET = "M26gP6GkeXVUdTicME952BtPBvcxDrLejA4MqKKZAHKB8iKDuoWyJUr74sxt";

    public String createToken(Map<String, Object> claims,String userName){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                .signWith(SignatureAlgorithm.HS256, getSingKey()).compact();
    }

    public Key getSingKey (){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String userName, long id){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);
        return createToken(claims, userName);
    }

    private Claims extractClaims(String token){
        return Jwts.
                parserBuilder()
                .setSigningKey(getSingKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaims (String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractClaims(token);
        return claimsResolver.apply(claims);
    }

    public Date extraExpiration(String token){
        return extractClaims(token, Claims::getExpiration);
    }

    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }

    public Boolean isTokenExpired(String token){
        return extraExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
}