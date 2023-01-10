package com.azumo.MyStore.warehouse;

import com.azumo.MyStore.common.events.DomainEvent;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;

/**
 * Goods Missed domain event.
 * <p>
 * Raised when a product is missed in the stock (sold out) and requested to be fetched.
 * <p>
 * Some other service could take care of it (eg. notify a supplier).
 * <br>In the current workflow the delivery is dispatched even when something is missing. This will be just delivered later.
 */
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"productCode", "amount"})
@ToString
public final class GoodsMissed implements DomainEvent {

    public final @NonNull Instant when;
    public final @NonNull String productCode;
    public final @NonNull Integer amount;
}
