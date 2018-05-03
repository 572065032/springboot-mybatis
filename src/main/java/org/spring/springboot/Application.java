package org.spring.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.spring.springboot.util.jedisTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("org.spring.springboot.dao")
//@ImportResource("classpath:spring-redis.xml")
@ImportResource(locations = {"classpath:dubbo.xml","classpath:spring-redis.xml"})
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        ConfigurableApplicationContext cont = SpringApplication.run(Application.class,args);
//
        jedisTest.setInstance((jedisTest)cont.getBean("jedisTest"));
//        r.test();
    }
}
