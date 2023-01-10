package com.azumo.MyStore.shipping.delivery.jdbc;

import com.azumo.MyStore.common.events.EventPublisher;
import com.azumo.MyStore.shipping.delivery.Address;
import com.azumo.MyStore.shipping.delivery.Delivery;
import com.azumo.MyStore.shipping.delivery.OrderId;
import com.azumo.MyStore.shipping.delivery.PrepareDelivery;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * JDBC implementation for Prepare Delivery use-cases.
 */
@RequiredArgsConstructor
@Slf4j
class PrepareDeliveryJdbc implements PrepareDelivery {

    private final @NonNull JdbcTemplate jdbcTemplate;
    private final @NonNull EventPublisher eventPublisher;

    @Transactional
    @Override
    public void prepare(@NonNull OrderId orderId, @NonNull Address address) {
        Delivery delivery = new DeliveryJdbc(orderId, address, jdbcTemplate, eventPublisher);
        delivery.prepare();
    }
}
