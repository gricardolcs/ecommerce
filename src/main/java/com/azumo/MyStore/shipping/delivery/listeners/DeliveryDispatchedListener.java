package com.azumo.MyStore.shipping.delivery.listeners;

import com.azumo.MyStore.shipping.delivery.DispatchDelivery;
import com.azumo.MyStore.shipping.delivery.OrderId;
import com.azumo.MyStore.shipping.dispatching.DeliveryDispatched;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
class DeliveryDispatchedListener {

    private final @NonNull DispatchDelivery dispatchDelivery;

    @TransactionalEventListener
    @Async
    public void on(DeliveryDispatched event) {
        dispatchDelivery.byOrder(new OrderId(event.orderId));
    }
}
