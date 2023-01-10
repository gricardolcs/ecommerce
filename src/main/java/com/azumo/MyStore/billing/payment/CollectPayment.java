package com.azumo.MyStore.billing.payment;

import com.azumo.MyStore.common.primitives.Money;

public interface CollectPayment {

    void collect(ReferenceId referenceId, Money total);
}
