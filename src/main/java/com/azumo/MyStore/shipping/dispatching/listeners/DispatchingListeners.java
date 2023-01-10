package com.azumo.MyStore.shipping.dispatching.listeners;

import com.azumo.MyStore.payment.PaymentCollected;
import com.azumo.MyStore.sales.order.OrderPlaced;
import com.azumo.MyStore.shipping.delivery.DeliveryPrepared;
import com.azumo.MyStore.shipping.dispatching.DispatchingSaga;
import com.azumo.MyStore.shipping.dispatching.OrderId;
import com.azumo.MyStore.warehouse.GoodsFetched;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
class DispatchingListeners {

    private final @NonNull DispatchingSaga saga;

    @TransactionalEventListener
    @Async
    public void on(DeliveryPrepared event) {
        saga.prepared(new OrderId(event.orderId));
    }

    @TransactionalEventListener
    @Async
    public void on(OrderPlaced event) {
        saga.accepted(new OrderId(event.orderId));
    }

    @TransactionalEventListener
    @Async
    public void on(GoodsFetched event) {
        saga.fetched(new OrderId(event.orderId));
    }

    @TransactionalEventListener
    @Async
    public void on(PaymentCollected event) {
        saga.paid(new OrderId(event.referenceId));
    }
}
