package com.csftgroup.ocsp.atomic.project.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.csftgroup.ocsp.atomic.project.manage.mapper")
@EnableDiscoveryClient
@EnableTransactionManagement
public class ProjectmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectmanageApplication.class, args);
    }

}
