package com.test.app.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class SOJSONExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {

            ModelAndView mv = new ModelAndView();

            // set status code
            response.setStatus(HttpStatus.BAD_REQUEST.value());

            // set content type
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            // set character encoding
            response.setCharacterEncoding("UTF-8");

            response.setHeader("Cache-Control", "no-cache, must-revalidate");


            String message = e.getMessage();
            String remsg = "抱歉，您的请求出现异常，我们已经监控到异常信息。您可以尝试再次请求。多次出现异常或需要更快的解决，加QQ群：608222884，验证消息 sojson api，反馈问题。";
            int status = 400;
            if("no_city_id".equalsIgnoreCase(message)){
                remsg = "CityId不在返回之内,加QQ群：608222884，验证消息 sojson api，反馈问题。";
                status = 403;
            }
            if(null != message){
                remsg = message;
            }
            try {
                response.getWriter().write(String.format("{\"status\":%s,\"message\":\"%s\"}",status,remsg));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        return mv;
    }
}
