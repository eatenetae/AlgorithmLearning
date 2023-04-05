package com.example.algorithmlearning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
//@MapperScan("com.example.algorithmlearning.mapper")
public class AlgorithmLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmLearningApplication.class, args);
    }

}
