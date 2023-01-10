package com.azumo.MyStore.payment.jdbc;

import com.azumo.MyStore.payment.FindPayments;
import com.azumo.MyStore.payment.Payments;
import com.azumo.MyStore.common.events.EventPublisher;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Find Payments use-cases.
 */
@RequiredArgsConstructor
final class FindPaymentsJdbc implements FindPayments {

    private final @NonNull JdbcTemplate jdbcTemplate;
    private final @NonNull EventPublisher eventPublisher;

    @Override
    public Payments all() {
        return new PaymentsJdbc(
                "SELECT id, reference_id referenceId, total, status FROM payments",
                jdbcTemplate, eventPublisher);
    }
}
