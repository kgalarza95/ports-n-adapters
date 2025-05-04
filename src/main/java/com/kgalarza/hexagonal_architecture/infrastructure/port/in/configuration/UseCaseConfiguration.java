package com.kgalarza.hexagonal_architecture.infrastructure.port.in.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.kgalarza.hexagonal_architecture.application",
        includeFilters = {
                @ComponentScan.Filter(type = org.springframework.context.annotation.FilterType.REGEX, pattern = "^.+Service")
        } )
public class UseCaseConfiguration {
}
