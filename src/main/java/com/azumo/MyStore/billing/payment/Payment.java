package com.azumo.MyStore.billing.payment;

import com.azumo.MyStore.common.primitives.Money;

public interface Payment {

    PaymentId id();
    ReferenceId referenceId();
    Money total();

    void request();
    void collect();
    boolean isRequested();
    boolean isCollected();

    final class PaymentAlreadyRequestedException extends  IllegalStateException{}
    final class PaymentNotRequestedYetException extends IllegalStateException{}
    final class PaymentAlreadyCollectedException extends IllegalStateException{}

}
