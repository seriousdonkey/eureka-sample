package de.seriousdonkey.eureka.client.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/home")
public class HomeController {

    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {

        Application application = eurekaClient.getApplication("spring-cloud-eureka-client");

        return "Hello World!";
    }

}
