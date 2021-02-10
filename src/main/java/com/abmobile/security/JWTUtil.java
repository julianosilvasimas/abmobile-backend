package com.abmobile.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JWTUtil {
	@Value("SequenciaDeCaracteresParaAssinarToken")  //se funcionar integração com application.propperties: @Value("${jwt.secret}") 
	private String secret;
 	@Value("21600000")    //se funcionar integração com application.propperties: @Value("${jwt.expiration}")
	private Long expiration;
	
	public String generateToken(String username, String id, Collection<? extends GrantedAuthority> permissao) {
		
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("jti", id);
		
		for (GrantedAuthority auth: permissao) {
			claims.put("roles",auth);
		}
        claims.put("roles", permissao);
		
		return Jwts.builder()
				.setSubject(username)
				.setId(id)
				.setClaims(claims)
				.setIssuer("com.abmobile")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
	
	public boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}

	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}

	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		}
		catch (Exception e) {
			return null;
		}
	}
	
}