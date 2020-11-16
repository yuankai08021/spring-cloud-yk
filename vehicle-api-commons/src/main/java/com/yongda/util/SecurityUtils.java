package com.yongda.util;


import org.springframework.util.DigestUtils;

/**
 * @Auther yuank
 * @CreateTime 2020/11/12 11:10
 **/

public class SecurityUtils {

    public static final String AUTHORITIES_KEY = "auth";

    public static String getEncodePasswd(String passwd) {
        return DigestUtils.md5DigestAsHex(DigestUtils.md5DigestAsHex(
                (passwd + "_vechile_passwd_yongda").getBytes()).getBytes());
    }

  /*  public String createToken(Authentication authentication) {
        *//*
         * 获取权限列表
         *//*
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return jwtBuilder
                // 加入ID确保生成的 Token 都不一致
                .setId(IdUtil.simpleUUID())
                .claim(AUTHORITIES_KEY, authorities)
                .setSubject(authentication.getName())
                .compact();
    }*/

}
