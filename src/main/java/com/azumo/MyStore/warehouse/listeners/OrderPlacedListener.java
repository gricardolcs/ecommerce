package com.azumo.MyStore.warehouse.listeners;

import com.azumo.MyStore.sales.order.OrderPlaced;
import com.azumo.MyStore.warehouse.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.stream.Collectors;

/**
 * Warehouse listener for OrderPlaced event.
 */
@Component("warehouse-orderPlacedListener") // a custom name to avoid collision
@RequiredArgsConstructor
class OrderPlacedListener {

    private final @NonNull FetchGoods fetchGoods;

    @TransactionalEventListener
    @Async
    public void on(OrderPlaced event) {
        fetchGoods.fetchFromOrder(
                new OrderId(event.orderId),
                event.items.entrySet().stream()
                        .map(item -> new ToFetch(new ProductId(item.getKey()), new Amount(item.getValue())))
                        .collect(Collectors.toList()));
    }
}
