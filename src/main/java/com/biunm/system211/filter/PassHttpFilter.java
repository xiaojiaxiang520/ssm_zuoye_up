package com.biunm.system211.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  配置全局请求头
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "authFilter") //这里的“/*” 表示的是需要拦截的请求路径
public class PassHttpFilter implements Filter {
    private static final String OPTIONS = "OPTIONS";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //用来过滤下面的OPTIONS
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //
        HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
        httpResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        //这一步十分重要
        httpResponse.setHeader("Access-Control-Allow-Headers","token");


        if(OPTIONS.equalsIgnoreCase(request.getMethod()))
            return;

        filterChain.doFilter(servletRequest, httpResponse);
    }

    @Override
    public void destroy() {

    }

}
