package com.school;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScholConfig {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
