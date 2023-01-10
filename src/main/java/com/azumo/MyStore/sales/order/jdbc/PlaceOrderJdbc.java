package com.azumo.MyStore.sales.order.jdbc;

import com.azumo.MyStore.common.events.EventPublisher;
import com.azumo.MyStore.common.primitives.Money;
import com.azumo.MyStore.sales.order.OrderId;
import com.azumo.MyStore.sales.order.PlaceOrder;
import com.azumo.MyStore.sales.order.PlaceableOrder;
import com.azumo.MyStore.sales.order.item.OrderItem;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class PlaceOrderJdbc implements PlaceOrder {

    private final @NonNull JdbcTemplate jdbcTemplate;

    private final @NonNull EventPublisher eventPublisher;


    @Override
    public void place(@NonNull OrderId orderId, Collection<OrderItem> items, @NonNull Money total) {
        new OrderJdbc(orderId, total, items, jdbcTemplate, eventPublisher)
                .place();
    }
}
