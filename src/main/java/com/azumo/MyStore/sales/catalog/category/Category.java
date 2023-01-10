package com.azumo.MyStore.sales.catalog.category;

public interface Category {
    CategoryId id();
    Uri uri();
    Title title();
    void changeTitle(Title title);
}
