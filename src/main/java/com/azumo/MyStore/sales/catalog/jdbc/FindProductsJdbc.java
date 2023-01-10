package com.azumo.MyStore.sales.catalog.jdbc;

import com.azumo.MyStore.sales.catalog.FindProducts;
import com.azumo.MyStore.sales.catalog.product.Product;
import com.azumo.MyStore.sales.catalog.product.ProductId;
import com.azumo.MyStore.sales.catalog.product.Products;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Find Products use-cases.
 */
@RequiredArgsConstructor
@Slf4j
final class FindProductsJdbc implements FindProducts {

    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public Products all() {
        return new ProductsJdbc(
                "SELECT id, title, description, price FROM products",
                jdbcTemplate);
    }

    @Override
    public Product byId(ProductId id) {
        return new ProductsJdbc(
                "SELECT id, title, description, price FROM products WHERE id = ?",
                id.value(), jdbcTemplate).stream()
                .findFirst()
                .orElseGet(UnknownProduct::new);
    }
}
