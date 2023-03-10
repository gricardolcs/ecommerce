package com.azumo.MyStore.warehouse.jdbc;

import com.azumo.MyStore.common.events.EventPublisher;
import com.azumo.MyStore.warehouse.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Collection;

/**
 * JDBC implementation for Fetching Goods use-cases.
 */
@RequiredArgsConstructor
@Slf4j
class GoodsFetchingJdbc implements FetchGoods, RemoveFetchedGoods {

    private final @NonNull Warehouse warehouse;
    private final @NonNull JdbcTemplate jdbcTemplate;
    private final @NonNull EventPublisher eventPublisher;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void fetchFromOrder(OrderId orderId, Collection<ToFetch> toFetch) {
        toFetch.forEach(item -> fetch(item, orderId));

        eventPublisher.raise(new GoodsFetched(Instant.now(), orderId.value()));

        log.info("Goods fetched: {}", toFetch);
    }

    private void fetch(ToFetch item, OrderId orderId) {
        InStock inStock = warehouse.leftInStock(item.productId());
        if (!inStock.hasEnough(item.amount())) {
            eventPublisher.raise(new GoodsMissed(
                    Instant.now(), item.productId().value(), inStock.needsYet(item.amount()).value()));
        }
        if (!inStock.isSoldOut()) {
            int amountToFetch = Math.min(item.amount().value(), inStock.amount().value());
            jdbcTemplate.update(
                    "INSERT INTO fetched_products VALUES (?, ?, ?)",
                    item.productId().value(), amountToFetch, orderId.value());

            jdbcTemplate.update(
                    "UPDATE products_in_stock SET amount = amount - ? WHERE product_id = ?",
                    amountToFetch, item.productId().value());
        }
    }

    @Transactional
    @Override
    public void removeForOrder(OrderId orderId) {
        jdbcTemplate.update(
                "DELETE FROM fetched_products WHERE order_id = ?",
                orderId.value());

        log.info("Fetched goods removed: {}", orderId);
    }
}
