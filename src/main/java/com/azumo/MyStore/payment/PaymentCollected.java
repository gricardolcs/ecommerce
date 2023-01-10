package com.azumo.MyStore.payment;

import com.azumo.MyStore.common.events.DomainEvent;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;

/**
 * Payment Collected domain event.
 */
@RequiredArgsConstructor
@EqualsAndHashCode(of = "referenceId")
@ToString
public final class PaymentCollected implements DomainEvent {

    public final @NonNull Instant when;
    public final @NonNull String referenceId;
}
