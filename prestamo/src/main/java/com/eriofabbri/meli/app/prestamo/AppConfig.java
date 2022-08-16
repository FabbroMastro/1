package com.eriofabbri.meli.app.prestamo;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class AppConfig {

    @Bean("targetClienteRest")
    @LoadBalanced
    public RestTemplate TargetRestTemplate() {
        return new RestTemplate();
    }

}
