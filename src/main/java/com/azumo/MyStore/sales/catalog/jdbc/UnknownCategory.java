package com.azumo.MyStore.sales.catalog.jdbc;

import com.azumo.MyStore.sales.catalog.category.Category;
import com.azumo.MyStore.sales.catalog.category.CategoryId;
import com.azumo.MyStore.sales.catalog.category.Title;
import com.azumo.MyStore.sales.catalog.category.Uri;
import lombok.ToString;

/**
 * Null object implementation for Category entity.
 */
@ToString
final class UnknownCategory implements Category {

    @Override
    public CategoryId id() {
        return new CategoryId(0);
    }

    @Override
    public Uri uri() {
        return new Uri("unknown");
    }

    @Override
    public Title title() {
        return new Title("unknown category");
    }

    @Override
    public void changeTitle(Title title) {
        // do nothing
    }
}
