package com.umutyildiz.store_service.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }
}
