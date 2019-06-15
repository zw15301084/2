package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class ViewLogAuditorAware implements AuditorAware<String> {

    @Value("testName")
    private String userName;

    public Optional<String> getCurrentAuditor() {
        return Optional.of(userName);
    }
}
