package com.joseherrera.Backend.utils;

import com.joseherrera.Backend.exception.WrongTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import com.joseherrera.Backend.interfaces.IJwToken;
import io.jsonwebtoken.impl.crypto.DefaultSignatureValidatorFactory;
import java.util.Objects;

@Getter
public class JwToken implements IJwToken {

    private final String secret;
    private Long expTime = 0L;
    private Map<String, Object> claims;

    public JwToken(String secret) {
        this.secret = secret;
    }

    public JwToken(String secret, Long expTime) {
        this.secret = secret;
        this.expTime = expTime;
        this.claims = new HashMap<>();
    }

    @Override
    public void addClaim(String key, Object value) {
        claims.put(key, value);
    }

    @Override
    public String generateToken() {
        Long time = System.currentTimeMillis();
        return "Bearer " + Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secret)
                .setClaims(claims)
                .setIssuedAt(new Date(time * 1000))
                .compact();
    }

    @Override
    public Token getTokenPayload(String headerToken) throws WrongTokenException {
        try {

            if (Objects.isNull(headerToken)) {
                throw new WrongTokenException("Header sin token");
            }
            
            String[] authHeaderSplit = headerToken.split(" ");
            String token = authHeaderSplit[1];

            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

            int pk = Integer.parseInt(claims.get("id").toString());
            int dni = Integer.parseInt(claims.get("dni").toString());

            return new Token(pk, dni);

        } catch (MalformedJwtException e) {
            throw new WrongTokenException("Token inválido");
        }
    }

   

}
