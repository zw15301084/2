package com.example.javaee.h4.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class TrainerRouter{

    @Bean
    public RouterFunction<ServerResponse> route(TrainerHandler handler) {
        return RouterFunctions
                .route(GET("/trainer/list").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/trainer/show/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)
                .andRoute(POST("/trainer/add").and(accept(MediaType.APPLICATION_JSON)), handler::save)
                .andRoute(DELETE("/trainer/delete/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete)
                .andRoute(PUT("/trainer/update/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::update);
    }

}