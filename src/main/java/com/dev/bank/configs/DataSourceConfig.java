package com.dev.bank.configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.dev.bank.repositories"})
@EntityScan(basePackages = {"com.dev.bank.models.dao"})
@EnableJpaRepositories("com.dev.bank.repositories")
public class DataSourceConfig {
}
