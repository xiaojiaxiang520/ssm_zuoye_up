package com.biunm.system211.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.biunm.system211.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Result result = new Result();
        //1、获取token
        String token = request.getHeader("token");
        System.out.println("前端获取的token:"+token);
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        System.out.println("请求参数："+parameterMap.size());
//        System.out.println(request.getParameter("username"));
//        System.out.println(request.getParameter("password"));


        if(token !=null)
        {
            //2、查询用户是否存在
            String JsonUser = redisTemplate.opsForValue().get(token);
            if(JsonUser==null)
            {
                System.out.println("===================token不存在===================");
                //3、不存在则返回
                result.setCode(205);//token过期
                result.setMsg("请重新登录");
                //将result,json数据化
                String jsonObject = JSONObject.toJSONString(result);
                returnJson(response,jsonObject);//通过这个response写出回去
                return false;
            }
            //当这个通过的时候，说明存在，切真实
            return true;
        }else{
            System.out.println("===================token为空===================");
            //这种就不存在token
            result.setCode(206);//token过期，token不存在
            result.setMsg("请重新登录");
            String jsonObject = JSONObject.toJSONString(result);
            returnJson(response,jsonObject);//通过这个response写出回去
            return false;
        }
//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        this.postHandle( httpServletRequest,  httpServletResponse,  o,  modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


    /*返回客户端数据*/
    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}
