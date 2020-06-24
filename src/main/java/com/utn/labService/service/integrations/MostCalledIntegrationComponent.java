package com.utn.labService.service.integrations;

import com.utn.labService.model.MostCalled;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
public class MostCalledIntegrationComponent {
    private RestTemplate rest;
    private static String url = "http://localhost:8080/users/{userId}/mostCalled";

    @PostConstruct
    private void init() {
        rest = new RestTemplateBuilder()
                .build();
    }

    public MostCalled getMostCalled(String userId) {
        url = url.replace("{userId}", userId);
        return rest.getForObject(url, MostCalled.class);
    }
}
