package com.azumo.MyStore.sales.order.jdbc;

import com.azumo.MyStore.common.events.EventPublisher;
import com.azumo.MyStore.common.primitives.Money;
import com.azumo.MyStore.sales.order.OrderId;
import com.azumo.MyStore.sales.order.OrderPlaced;
import com.azumo.MyStore.sales.order.PlaceableOrder;
import com.azumo.MyStore.sales.order.item.OrderItem;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * JDBC implementation for Order entity.
 */
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "total", "items"})
@Slf4j
final class OrderJdbc implements PlaceableOrder {

    private final @NonNull OrderId id;
    private final @NonNull Money total;
    private final @NonNull Collection<OrderItem> items;

    private final @NonNull JdbcTemplate jdbcTemplate;
    private final @NonNull EventPublisher eventPublisher;

    private boolean placed = false;

    public OrderJdbc(@NonNull OrderId id, @NonNull Money total, @NonNull Collection<OrderItem> items,
                     @NonNull JdbcTemplate jdbcTemplate, @NonNull EventPublisher eventPublisher) {
        if (items.isEmpty()) {
            throw new OrderHasNoItemsException();
        }
        this.id = id;
        this.items = items;
        this.total = total;
        this.jdbcTemplate = jdbcTemplate;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public OrderId id() {
        return id;
    }

    @Override
    public List<OrderItem> items() {
        return List.copyOf(items);
    }

    @Override
    public Money total() {
        return total;
    }

    @Override
    public void place() {
        if (placed) {
            throw new OrderAlreadyPlacedException();
        }
        jdbcTemplate.update("INSERT INTO orders VALUES (?, ?)", id.value(), total.value());

        items.forEach(item -> jdbcTemplate.update(
                "INSERT INTO order_items VALUES (?, ?, ?)",
                item.productId().value(), item.quantity().value(), id.value()));
        placed = true;

        eventPublisher.raise(toOrderPlaced());
        log.info("Order placed: {}", this);
    }

    private OrderPlaced toOrderPlaced() {
        return new OrderPlaced(
                Instant.now(),
                id.value(),
                items.stream().collect(groupingBy(
                        item -> item.productId().value(),
                        summingInt(item -> item.quantity().value()))),
                total.value());
    }
}
