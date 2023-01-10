package com.azumo.MyStore.billing.payment.jdbc;

import com.azumo.MyStore.billing.payment.CollectPayment;
import com.azumo.MyStore.billing.payment.Payment;
import com.azumo.MyStore.billing.payment.ReferenceId;
import com.azumo.MyStore.common.events.EventPublisher;
import com.azumo.MyStore.common.primitives.Money;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class CollectPaymentJdbc implements CollectPayment {

    private final @NonNull JdbcTemplate jdbcTemplate;
    private final @NonNull EventPublisher eventPublisher;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void collect(ReferenceId referenceId, Money total) {
        Payment payment = new PaymentJdbc(referenceId, total, jdbcTemplate, eventPublisher);
        payment.request();
        payment.collect();
    }
}
