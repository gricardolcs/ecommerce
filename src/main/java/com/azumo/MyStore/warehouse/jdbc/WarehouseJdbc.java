package com.azumo.MyStore.warehouse.jdbc;

import com.azumo.MyStore.warehouse.Amount;
import com.azumo.MyStore.warehouse.InStock;
import com.azumo.MyStore.warehouse.ProductId;
import com.azumo.MyStore.warehouse.Warehouse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Warehouse use-cases.
 */
@RequiredArgsConstructor
final class WarehouseJdbc implements Warehouse {

    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public InStock leftInStock(ProductId productId) {
        return jdbcTemplate.queryForList(
                "SELECT amount FROM products_in_stock WHERE product_id = ?",
                Integer.class, productId.value())
                .stream().findAny()
                .map(Amount::new)
                .map(InStock::new)
                .orElseGet(() -> new InStock(Amount.ZERO));
    }

    @Override
    public void putIntoStock(ProductId productId, Amount amount) {
        jdbcTemplate.update(
                "INSERT INTO products_in_stock VALUES (?, ?)",
                productId.value(), amount.value());
    }
}
