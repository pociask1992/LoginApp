package com.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.example.domain.Login;


@Configuration
public class RepositoryConfiguration extends RepositoryRestMvcConfiguration {

	@Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Login.class);
        
        config.setBasePath("/api");
        config.setReturnBodyOnCreate(true);
    }
}
