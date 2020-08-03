package com.csftgroup.ocsp.business.project.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjectmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectmanageApplication.class, args);
    }

}
