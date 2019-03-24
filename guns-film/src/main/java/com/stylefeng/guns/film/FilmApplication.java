package com.stylefeng.guns.film;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Michael.Chu
 * @date 2019-03-17
 */
@SpringBootApplication
@EnableDubboConfiguration
public class FilmApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmApplication.class, args);
    }
}
