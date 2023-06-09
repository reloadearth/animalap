package com.nzr.animalap;

import  org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.nzr.animalap.mapper")
public class AnimalapApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalapApplication.class, args);
    }

}
