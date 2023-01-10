package com.azumo.MyStore.common.events;

import com.azumo.MyStore.billing.payment.PaymentCollected;

public interface EventPublisher {
    void raise(DomainEvent event);
}
