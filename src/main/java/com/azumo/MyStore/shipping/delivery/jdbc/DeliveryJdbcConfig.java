package com.azumo.MyStore.shipping.delivery.jdbc;

import com.azumo.MyStore.common.events.EventPublisher;
import com.azumo.MyStore.shipping.delivery.FindDeliveries;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Configuration for JDBC implementation for Delivery service.
 */
@Configuration
class DeliveryJdbcConfig {

    @Bean
    FindDeliveriesJdbc findDeliveriesJdbc(JdbcTemplate jdbcTemplate, EventPublisher eventPublisher) {
        return new FindDeliveriesJdbc(jdbcTemplate, eventPublisher);
    }

    @Bean
    PrepareDeliveryJdbc prepareDeliveryJdbc(JdbcTemplate jdbcTemplate, EventPublisher eventPublisher) {
        return new PrepareDeliveryJdbc(jdbcTemplate, eventPublisher);
    }

    @Bean
    DispatchDeliveryJdbc dispatchDeliveryJdbc(FindDeliveries findDeliveries) {
        return new DispatchDeliveryJdbc(findDeliveries);
    }
}
