package com.azumo.MyStore.payment.jdbc;

import com.azumo.MyStore.payment.CollectPayment;
import com.azumo.MyStore.payment.Payment;
import com.azumo.MyStore.payment.ReferenceId;
import com.azumo.MyStore.common.events.EventPublisher;
import com.azumo.MyStore.common.primitives.Money;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * JDBC implementation for Collect Payment use-cases.
 */
@RequiredArgsConstructor
class CollectPaymentJdbc implements CollectPayment {

    private final @NonNull JdbcTemplate jdbcTemplate;
    private final @NonNull EventPublisher eventPublisher;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void collect(ReferenceId referenceId, Money total) {
        Payment payment = new PaymentJdbc(referenceId, total, jdbcTemplate, eventPublisher);
        payment.request();

        // here an external service like PayPal or Visa is called...

        payment.collect();
    }
}
