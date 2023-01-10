package com.azumo.MyStore.sales.order.jdbc;

import com.azumo.MyStore.common.primitives.Money;
import com.azumo.MyStore.sales.order.Order;
import com.azumo.MyStore.sales.order.OrderId;
import com.azumo.MyStore.sales.order.item.OrderItem;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * Null object implementation for Order entity.
 */
@ToString
final class UnknownOrder implements Order {

    @Override
    public OrderId id() {
        return new OrderId(0);
    }

    @Override
    public List<OrderItem> items() {
        return Collections.emptyList();
    }

    @Override
    public Money total() {
        return Money.ZERO;
    }
}
