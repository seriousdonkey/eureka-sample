package de.seriousdonkey.eureka.discovery.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaDiscoveryClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaDiscoveryClientApplication.class, args);
    }

}
