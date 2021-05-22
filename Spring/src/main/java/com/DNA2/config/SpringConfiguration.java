package com.DNA2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * @Description Spring核心配置类
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/19 9:20
 */
////标志该类是Spring核心配置类
//@Configuration
//配置组件扫描
@ComponentScan("com.DNA2")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
