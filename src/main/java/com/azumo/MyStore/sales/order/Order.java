package com.azumo.MyStore.sales.order;

import com.azumo.MyStore.common.primitives.Money;
import com.azumo.MyStore.sales.order.item.OrderItem;

import java.util.List;

/**
 * Order entity.
 */
public interface Order {

    OrderId id();

    List<OrderItem> items();

    Money total();

    /**
     * OrderHasNoItemsException is thrown when the Order has no items.
     */
    final class OrderHasNoItemsException extends IllegalStateException {
    }
}
