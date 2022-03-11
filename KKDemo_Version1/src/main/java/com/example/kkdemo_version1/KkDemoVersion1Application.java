package com.example.kkdemo_version1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com/example/kkdemo_version1/Mappers")
public class KkDemoVersion1Application {

    public static void main(String[] args){
        SpringApplication.run(KkDemoVersion1Application.class, args);
    }

}
