package com.azumo.MyStore.shipping.dispatching;

import com.azumo.MyStore.common.events.DomainEvent;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;

/**
 * Delivery Dispatched domain event.
 */
@RequiredArgsConstructor
@EqualsAndHashCode(of = "orderId")
@ToString
public final class DeliveryDispatched implements DomainEvent {

    public final @NonNull Instant when;
    public final @NonNull String orderId;
}
