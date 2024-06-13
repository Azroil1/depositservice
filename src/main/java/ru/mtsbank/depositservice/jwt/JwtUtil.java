package ru.mtsbank.depositservice.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtUtil {
    @Value("${jwt.secret}")
    private String SECRET;


    private SecretKey init(){
        byte[] decode = Base64.getDecoder().decode(SECRET);
        SecretKey secretKey = new SecretKeySpec(decode, "HmacSHA256");
        return secretKey;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(init())
                    .build()
                    .parseClaimsJws(token);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public Map<String, Integer> extractAccountId(String token) {
        log.info(token);
        log.info(init().toString());
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(init()).build().parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Map<String, Integer> accountIds = new HashMap<>();
        accountIds.put("bankAccountId", claims.get("bankAccountId", Integer.class));
        accountIds.put("customerAccountId", claims.get("customerAccountId", Integer.class));
        return accountIds;
    }
}
