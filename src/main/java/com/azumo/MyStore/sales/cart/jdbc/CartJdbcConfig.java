package com.azumo.MyStore.sales.cart.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class CartJdbcConfig {

    @Bean
    RetrieveCartJdbc retrieveCartJdbc(JdbcTemplate jdbcTemplate){
        return new RetrieveCartJdbc(jdbcTemplate);
    }
}
