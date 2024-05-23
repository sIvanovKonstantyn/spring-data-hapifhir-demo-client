package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring.data.fhir.config.EnableFhirRepositories;

@SpringBootApplication
@EnableFhirRepositories
public class SpringDataFhirDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataFhirDemoApplication.class, args);
    }
}



