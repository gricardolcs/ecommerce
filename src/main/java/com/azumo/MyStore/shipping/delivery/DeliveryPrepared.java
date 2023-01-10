package com.azumo.MyStore.shipping.delivery;

import com.azumo.MyStore.common.events.DomainEvent;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;

/**
 * Delivery Prepared domain event.
 */
@RequiredArgsConstructor
@EqualsAndHashCode(of = "orderId")
@ToString
public final class DeliveryPrepared implements DomainEvent {

    public final @NonNull Instant when;
    public final @NonNull String orderId;
}
