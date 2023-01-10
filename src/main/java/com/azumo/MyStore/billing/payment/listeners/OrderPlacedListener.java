package com.azumo.MyStore.billing.payment.listeners;

import com.azumo.MyStore.billing.payment.CollectPayment;
import com.azumo.MyStore.billing.payment.ReferenceId;
import com.azumo.MyStore.common.primitives.Money;
import com.azumo.MyStore.sales.order.OrderPlaced;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component("payment-orderPlacedListener")
@RequiredArgsConstructor
public class OrderPlacedListener {

    private final @NonNull CollectPayment collectPayment;

    @TransactionalEventListener
    @Async
    public void on(OrderPlaced event){
        collectPayment.collect(
            new ReferenceId(event.orderId),
            new Money(event.total));
    }
}
