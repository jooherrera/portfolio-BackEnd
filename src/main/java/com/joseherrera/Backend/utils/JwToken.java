package com.joseherrera.Backend.utils;

import com.joseherrera.Backend.exception.WrongTokenException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import com.joseherrera.Backend.interfaces.IJwToken;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Objects;

@Getter
public class JwToken implements IJwToken {

    private final String secret;
    private Map<String, Object> claims;



    public JwToken(String secret) {
        this.secret = secret;
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
    public Token validate(String headerToken) throws WrongTokenException {
        try {

            if (Objects.isNull(headerToken)) {
                throw new WrongTokenException("No se encontro el Header con el token");
            }
            
            String[] authHeaderSplit = headerToken.split(" ");
            String token = authHeaderSplit[1];

            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

            int pk = Integer.parseInt(claims.get("id").toString());
            int dni = Integer.parseInt(claims.get("dni").toString());
            boolean isAdmin = Boolean.parseBoolean(claims.get("isAdmin").toString());

            return new Token(pk, dni, isAdmin);

        } catch (MalformedJwtException | WrongTokenException | ExpiredJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
            throw new WrongTokenException("Token inválido");
        }
    }

   

}
