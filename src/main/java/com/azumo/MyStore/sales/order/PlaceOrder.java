package com.azumo.MyStore.sales.order;

import com.azumo.MyStore.common.primitives.Money;
import com.azumo.MyStore.sales.order.item.OrderItem;

import java.util.Collection;

/**
 * Place Order use-case.
 */
public interface PlaceOrder {

    /**
     * Places a new order.
     *
     * @param orderId the order ID
     * @param items   the order items
     */
    void place(OrderId orderId, Collection<OrderItem> items, Money total);
}
