package com.azumo.MyStore.billing.payment.jdbc;

import com.azumo.MyStore.billing.payment.Payment;
import com.azumo.MyStore.billing.payment.Payments;
import com.azumo.MyStore.common.events.EventPublisher;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
final class PaymentsJdbc implements Payments {

    private  static final  int UNLIMITED = 100;
    private final @NonNull String query;
    private final @NonNull List<Object> queryParams;
    private final @NonNull JdbcTemplate jdbcTemplate;
    private final @NonNull EventPublisher eventPublisher;
    private int start = 0;
    private int limit = UNLIMITED;


    public PaymentsJdbc(@NonNull String query, @NonNull JdbcTemplate jdbcTemplate, @NonNull EventPublisher eventPublisher){
        this(query, List.of(), jdbcTemplate, eventPublisher);
    }

    @Override
    public Payments range(int start, int limit) {
        if(start < 0 || limit <= 0 || limit - start > UNLIMITED){
            throw  new IllegalArgumentException("Start must be greater than zero,"+
                "items count must be greater than zero and less or equal than " + UNLIMITED);
        }
        this.start = start;
        this.limit = limit;
        return this;
    }

    @Override
    public Payments range(int limit) {
        return range(0, limit);
    }

    @Override
    public Stream<Payment> Stram() {
        return null;
    }
}
