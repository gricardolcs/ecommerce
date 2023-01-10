package com.azumo.MyStore.sales.catalog;

import com.azumo.MyStore.sales.catalog.category.Uri;
import com.azumo.MyStore.sales.catalog.product.Products;

public interface FindProductsFromCategory {

    Products byUri(Uri categoryUri);
}
