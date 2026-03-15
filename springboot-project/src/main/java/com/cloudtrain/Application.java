package com.cloudtrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        System.out.println("Starting Spring Boot application...");
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from Spring Boot Project!");
        response.put("techStack", "Java + Spring Boot (Embedded Tomcat)");
        response.put("status", "Success");
        return response;
    }
}
