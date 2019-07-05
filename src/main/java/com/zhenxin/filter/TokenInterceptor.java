package com.zhenxin.filter;
import com.alibaba.druid.util.StringUtils;
import com.zhenxin.annotation.TokenToUser;
import com.zhenxin.pojo.JsonData;
import com.zhenxin.pojo.User;
import com.zhenxin.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.jws.Oneway;

/**
 * 请求校验
 */
@Component
public class TokenInterceptor implements HandlerMethodArgumentResolver {
    public boolean supportsParameter(MethodParameter methodParameter) {
        if(methodParameter.hasParameterAnnotation(TokenToUser.class)){
            return true;
        }
        return false;
    }

    /**
     * 拦截并解析token
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    public User resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        System.out.println(methodParameter);
        if(methodParameter.getParameterAnnotation(TokenToUser.class) instanceof TokenToUser) {
            String token = nativeWebRequest.getHeader("access_token");
            if(null == token || "" == token){
                token=nativeWebRequest.getParameter("access_token");

            }
            User user = new User();
            if (null != token || "" != token){
                Claims claims = JwtUtils.checkJWT(token);
                Integer userId = (Integer)claims.get("userId");
                String name = (String) claims.get("userName");
                System.out.println(userId);
                System.out.println(name);
                user.setUserName(name);
                user.setUserId(userId);
                user.setRandomSerict((String) claims.get("randomSerict"));
                return user;
            }
        }
        return null;
    }

//    public static void sendJsonMessage(HttpServletResponse response, Object obj) throws IOException {
//        response.setContentType("application/json; charset=utf-8");
//        PrintWriter writer = response.getWriter();
//        writer.print(gson.toJson(obj));
//        writer.close();
//        response.flushBuffer();
//    }




}
