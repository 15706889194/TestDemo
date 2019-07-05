package com.zhenxin.utils;

import com.zhenxin.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 */
public class JwtUtils {
    public static void main(String[] args) {
        System.out.println(1);
        User user=new User();
        user.setUserId(1);
        user.setRandomSerict("jahscisdco");
        user.setUserName("jiangxin");
        String s = JwtUtils.geneJsonWebToken(user);
        System.out.println(s);
        Claims claims =JwtUtils.checkJWT("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwidXNlcklkIjoxNiwidXNlck5hbWUiOiIxNTcwNjgxODkxOTQxIiwicmFuZG9tU2VyaWN0IjoiNjkzZjdlNDItNzkwMS00NTEzLTg3ZTAtODY0NGY4OTljYmUyIiwiaWF0IjoxNTYyMzM4MTA1LCJleHAiOjE1NjI5NDI5MDV9.MvEp-qcOXgezIKuYapqIK3DgvoajHki1GBnzM44jLcA");
        Integer userId = (Integer)claims.get("userId");
        String name = (String) claims.get("userName");
        System.out.println(userId);
        System.out.println(name);
//      request.setAttribute("user_id",userId);
//      request.setAttribute("name",name);


        System.out.println();


//            return claims;
    }




    public static final String SUBJECT = "xdclass";
    public static final long EXPIRE = 1000*60*60*24*7;  //过期时间，毫秒，一周
    //秘钥
    public static final  String APPSECRET = "xd666";
    /**
     * 生成jwt
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){

        if(user == null || user.getUserId() == null || user.getUserName() == null
                || user.getRandomSerict()==null){
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("userId",user.getUserId())
                .claim("userName",user.getUserName())
                .claim("randomSerict",user.getRandomSerict())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();
        return token;
    }


    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token ){

        try{
            final Claims claims =  Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return  claims;

        }catch (Exception e){ }
        return null;


    }

//    public static void main(String[] args) {
//        public Claims test1( ){
//            User user=new User();
//            user.setUserId(1);
//            user.setRandomSerict("jahscisdco");
//            user.setUserName("jiangxin");
//            String s = JwtUtils.geneJsonWebToken(user);
//            System.out.println(s);
//            Claims claims = JwtUtils.checkJWT(s);
//            System.out.println(claims);
//            return claims;
//    }
}
