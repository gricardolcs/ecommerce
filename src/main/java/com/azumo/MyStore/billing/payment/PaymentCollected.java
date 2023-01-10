package com.azumo.MyStore.billing.payment;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@RequiredArgsConstructor
@EqualsAndHashCode(of = "referenceId")
@ToString
public final class PaymentCollected {

    public final @NonNull Instant when;
    public final @NonNull String referenceId;

}
