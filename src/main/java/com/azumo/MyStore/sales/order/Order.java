package com.azumo.MyStore.sales.order;

import com.azumo.MyStore.common.primitives.Money;
import com.azumo.MyStore.sales.order.item.OrderItem;

import java.util.List;

public interface Order {

    OrderId id();
    List<OrderItem> items();
    Money total();

    final class OrderHasNoItemsException extends  IllegalStateException{}
}
