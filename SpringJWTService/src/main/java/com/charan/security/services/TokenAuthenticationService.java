package com.charan.security.services;

import java.util.Collections;
import java.util.Date;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.charan.security.models.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
 
@Service
public class TokenAuthenticationService {
	
	@Autowired
	UserDetailsService userDetailsService;
     
    static final long EXPIRATIONTIME = 1000 * 60; // 10 days
     
    static final String SECRET = "ThisIsASecret";
     
    static final String TOKEN_PREFIX = "Bearer";
     
    static final String HEADER_STRING = "Authorization";
 
    
    public String createToken(Long id) {
    	UserDetails userDetails = userDetailsService.getUser(id);
        Claims claims = Jwts.claims().setSubject(userDetails.getUserName());

        Date now = new Date();
        Date validity = new Date(now.getTime() + EXPIRATIONTIME);

        return Jwts.builder()//
            .setClaims(claims)//
            .setIssuedAt(now)//
            .setExpiration(validity)//
            .signWith(SignatureAlgorithm.HS256, SECRET)//
            .compact();
      }


      public String getUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
      }

      public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
          return bearerToken.substring(7, bearerToken.length());
        }
        return null;
      }

      public boolean validateToken(String token) {
        try {
          Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
          return true;
        } catch (JwtException | IllegalArgumentException e) {
        	System.out.println("Expired or invalid JWT token");
        	return false;
          
        }
      }
     
}
