package com.azumo.MyStore.warehouse;

import com.azumo.MyStore.common.events.DomainEvent;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;

/**
 * Goods Fetched domain event.
 */
@RequiredArgsConstructor
@EqualsAndHashCode(of = "orderId")
@ToString
public final class GoodsFetched implements DomainEvent {

    public final @NonNull Instant when;
    public final @NonNull String orderId;
}
