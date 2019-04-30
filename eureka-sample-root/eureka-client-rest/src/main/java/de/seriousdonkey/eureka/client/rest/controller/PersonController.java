package de.seriousdonkey.eureka.client.rest.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
import com.netflix.discovery.shared.Application;
import de.seriousdonkey.eureka.client.rest.ClientsProperties;
import de.seriousdonkey.eureka.client.rest.dtos.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController(value = "/persons")
public class PersonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private ClientsProperties clientsProperties;

    @RequestMapping(method = RequestMethod.GET)
    public List<PersonDto> persons() {
        final String url = String.format("%s/data/persons", getBaseUrl());
        final ResponseEntity<PersonDto[]> entity = restTemplate.getForEntity(url, PersonDto[].class);
        final PersonDto[] personDtos = entity.getBody();
        if (personDtos == null) {
            throw new RuntimeException("There was an error while getting person data.");
        }
        return Arrays.asList(personDtos);
    }

    @RequestMapping(value = "by-lastname", method = RequestMethod.GET)
    public List<PersonDto> personsByLastname(@RequestParam("lastname") final String lastname) {
        final String url = String.format("%s/data/persons/by-lastname?lastname=%s", getBaseUrl(), lastname);
        final ResponseEntity<PersonDto[]> entity = restTemplate.getForEntity(url, PersonDto[].class);
        final PersonDto[] personDtos = entity.getBody();
        if (personDtos == null) {
            throw new RuntimeException(("There was an error while getting person data."));
        }
        return Arrays.asList(personDtos);
    }

    private String getBaseUrl() {
        final Application application = eurekaClient.getApplication(clientsProperties.getClientData());
        final InstanceInfo instanceInfo = application.getInstances().get(0);
        return String.format("http://%s:%s", instanceInfo.getIPAddr(), instanceInfo.getPort());
    }

}
