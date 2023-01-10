package com.azumo.MyStore.sales.catalog;

import com.azumo.MyStore.sales.catalog.category.Categories;
import com.azumo.MyStore.sales.catalog.category.Category;
import com.azumo.MyStore.sales.catalog.category.CategoryId;

public interface FindCategories {
    Categories all();
    Category byId(CategoryId id);
}
