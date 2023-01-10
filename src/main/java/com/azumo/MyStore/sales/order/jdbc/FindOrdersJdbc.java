package com.azumo.MyStore.sales.order.jdbc;

import com.azumo.MyStore.common.events.EventPublisher;
import com.azumo.MyStore.common.primitives.Money;
import com.azumo.MyStore.common.primitives.Quantity;
import com.azumo.MyStore.sales.order.FindOrders;
import com.azumo.MyStore.sales.order.Order;
import com.azumo.MyStore.sales.order.OrderId;
import com.azumo.MyStore.sales.order.item.OrderItem;
import com.azumo.MyStore.sales.order.item.ProductId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * JDBC implementation for Find Orders use-cases.
 */
@RequiredArgsConstructor
@Slf4j
final class FindOrdersJdbc implements FindOrders {

    private final @NonNull JdbcTemplate jdbcTemplate;
    private final @NonNull EventPublisher eventPublisher;

    @Override
    public Order byId(OrderId id) {
        var items = jdbcTemplate.queryForList(
                "SELECT product_id, quantity FROM order_items WHERE order_id = ?",
                id.value());

        var order = jdbcTemplate.queryForList(
                "SELECT id, total FROM orders WHERE id = ?",
                id.value())
                .stream().findAny();

        return order
                .map(o -> toOrder(o, items.stream()
                        .map(this::toOrderItem)
                        .collect(Collectors.toList())))
                .orElseGet(UnknownOrder::new);
    }

    private Order toOrder(Map<String, Object> order, List<OrderItem> items) {
        return new OrderJdbc(
                new OrderId(order.get("id")),
                new Money(((BigDecimal) order.get("total")).floatValue()),
                items,
                jdbcTemplate,
                eventPublisher);
    }

    private OrderItem toOrderItem(Map<String, Object> item) {
        return new OrderItem(
                new ProductId(item.get("product_id")),
                new Quantity((Integer) item.get("quantity")));
    }
}
