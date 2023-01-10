package com.azumo.MyStore.sales.catalog.jdbc;

import com.azumo.MyStore.sales.catalog.FindProductsFromCategory;
import com.azumo.MyStore.sales.catalog.category.Uri;
import com.azumo.MyStore.sales.catalog.product.Products;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Find Products from Category use-cases.
 */
@RequiredArgsConstructor
@Slf4j
final class FindProductsFromCategoryJdbc implements FindProductsFromCategory {

    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public Products byUri(@NonNull Uri categoryUri) {
        return new ProductsJdbc(
                "SELECT p.id, p.title, p.description, p.price FROM products AS p " +
                "JOIN products_in_categories AS pc ON pc.product_id = p.id " +
                "JOIN categories AS c ON c.id = pc.category_id " +
                "WHERE c.uri = ?",
                categoryUri.value(), jdbcTemplate);
    }
}
