package com.biunm.system211.config;
import org.apache.ibatis.session.Configuration;
//import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * 原因是javabean中的属性名叫departmentName，而数据库字段名为department_name。
 * 如果有配置文件，我们可以在配置文件中开启驼峰命名法，现在没有配置文件，我们可以
 * 来配置自己的Mybatis规则，编写MybatisConfig类，开启驼峰命名法
 */
//@org.springframework.context.annotation.Configuration
public class MybatisConfig {
//    @Bean   //加入容器
//    // 自定义配置都要实现ConfigurationCustomizer接口
//    public ConfigurationCustomizer configurationCustomizer(){
//        return new ConfigurationCustomizer() {
//            @Override
//            public void customize(Configuration configuration) {
//                configuration.setMapUnderscoreToCamelCase(true); // 开启驼峰命名法启动规则
//            }
//        };
//    }
}
