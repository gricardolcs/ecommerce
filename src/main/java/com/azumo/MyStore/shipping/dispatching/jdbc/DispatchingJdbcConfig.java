package com.azumo.MyStore.shipping.dispatching.jdbc;

import com.azumo.MyStore.common.events.EventPublisher;
import com.azumo.MyStore.shipping.dispatching.Dispatching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Configuration for Dispatching JDBC.
 */
@Configuration
class DispatchingJdbcConfig {

    @Bean
    DispatchingSagaJdbc dispatchingSagaJdbc(Dispatching dispatching, JdbcTemplate jdbcTemplate) {
        return new DispatchingSagaJdbc(dispatching, jdbcTemplate);
    }

    @Bean
    DispatchingJdbc dispatchingJdbc(EventPublisher eventPublisher) {
        return new DispatchingJdbc(eventPublisher);
    }
}
