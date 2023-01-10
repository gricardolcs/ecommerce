package com.azumo.MyStore.sales.order;

import com.azumo.MyStore.common.primitives.Money;
import com.azumo.MyStore.sales.order.item.OrderItem;

import java.util.Collection;

public interface PlaceOrder {
    void place(OrderId orderId, Collection<OrderItem> items, Money total);
}
