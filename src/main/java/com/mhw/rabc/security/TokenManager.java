package com.mhw.rabc.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @version 1.0
 * @className: TokenManager
 * @description: TokenManager
 * @author: mhw
 * @date: 2022-03-01
 **/
@Component
public class TokenManager {

    private long tokenEcpiration = 24 * 60 * 60 * 1000;
    private String tokenSignKey = "123456";

    /**
     * 使用jwt根据用户名生成token
     */
    public String createToken(String username) {
        return Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + tokenEcpiration))
                .signWith(SignatureAlgorithm.HS512, tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
    }

    /**
     * 根据token字符串得到用户信息
     */
    public String getUserInfoFromToken(String token) {
        return Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * 删除token
     */
    public void removeToken(String token) {
    }
}
