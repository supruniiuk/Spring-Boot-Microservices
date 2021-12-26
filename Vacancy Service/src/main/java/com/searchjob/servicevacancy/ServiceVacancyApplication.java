package com.searchjob.servicevacancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceVacancyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVacancyApplication.class, args);
    }

}
