package com.azumo.MyStore.sales.catalog.jdbc;

import com.azumo.MyStore.sales.catalog.FindCategories;
import com.azumo.MyStore.sales.catalog.category.Categories;
import com.azumo.MyStore.sales.catalog.category.Category;
import com.azumo.MyStore.sales.catalog.category.CategoryId;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
public class FindCategoriesJdbc implements FindCategories {

    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public Categories all() {
        return new CategoriesJdbc(
                "SELECT id, uri, title FROM categories", jdbcTemplate);
    }

    @Override
    public Category byId(CategoryId id) {
        return new CategoriesJdbc(
                "SELECT id, uri, title FROM categories WHERE id = ?",
                id.value(), jdbcTemplate).stream()
                .findFirst()
                .orElseGet(UnknownCategory::new);
    }

}
