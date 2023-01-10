package com.azumo.MyStore.warehouse.listeners;

import com.azumo.MyStore.shipping.dispatching.DeliveryDispatched;
import com.azumo.MyStore.warehouse.OrderId;
import com.azumo.MyStore.warehouse.RemoveFetchedGoods;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Warehouse listener for DeliveryDispatched event.
 */
@Component("warehouse-deliveryDispatchedListener") // a custom name to avoid collision
@RequiredArgsConstructor
class DeliveryDispatchedListener {

    private final @NonNull RemoveFetchedGoods removeFetchedGoods;

    @TransactionalEventListener
    @Async
    public void on(DeliveryDispatched event) {
        removeFetchedGoods.removeForOrder(new OrderId(event.orderId));
    }
}
