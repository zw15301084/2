package com.example.javaee.h4.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.javaee.h4.entity"})
@EnableJpaRepositories(basePackages = {"com.example.javaee.h4.repository"})
public class RepositoryConfiguration {
}
