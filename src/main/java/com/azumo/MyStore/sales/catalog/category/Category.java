package com.azumo.MyStore.sales.catalog.category;

/**
 * Category entity.
 */
public interface Category {

    CategoryId id();

    Uri uri();

    Title title();

    void changeTitle(Title title);
}
