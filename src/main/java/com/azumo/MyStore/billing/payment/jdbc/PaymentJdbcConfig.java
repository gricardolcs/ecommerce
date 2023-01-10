package com.azumo.MyStore.billing.payment.jdbc;

import com.azumo.MyStore.common.events.EventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class PaymentJdbcConfig {

    @Bean
    FindPaymentsJdbc findPaymentsJdbc(JdbcTemplate jdbcTemplate, EventPublisher eventPublisher){
        return new FindPaymentsJdbc(jdbcTemplate, eventPublisher);
    }

    CollectPaymentJdbc collectPaymentJdbc(JdbcTemplate jdbcTemplate, EventPublisher eventPublisher){
        return new CollectPaymentJdbc(jdbcTemplate, eventPublisher);
    }
}
