package com.biunm.system211.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 *  Druid的配置类
 */
//@Configuration
public class DruidConfig {
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource druid()
//    {
//        return new DruidDataSource();
//    }
//
//    //配置一个Druid的监控
//    //1、配置一个管理后台的servlet
//    @Bean
//    public ServletRegistrationBean statViewServlet()
//    {
//        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
//        Map<String,String> map = new HashMap<>();
//        map.put("loginUsername", "jiaxiang");	//Druid后台的账号和密码
//        map.put("loginPassword", "jiaxiang");
//        map.put("allow", "localhost");
//        map.put("deny", "111.78.248.53");
//        bean.setInitParameters(map);
//        return bean;
//    }
//
//    // 2.配置一个管理后台的filter
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
//        Map<String,String> map = new HashMap<>();
//        map.put("exclusions", "*.js,*.css,/druid/*");
//        bean.setUrlPatterns(Arrays.asList("/*"));
//        bean.setInitParameters(map);
//        return bean;
//    }
}
