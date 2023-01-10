package com.azumo.MyStore.sales.catalog;

import com.azumo.MyStore.sales.catalog.category.Uri;
import com.azumo.MyStore.sales.catalog.product.Products;

/**
 * Find Products from Category use-case.
 */
public interface FindProductsFromCategory {

    /**
     * Lists products from the category by URI
     *
     * @param categoryUri the URI of the category
     * @return the products from the category
     */
    Products byUri(Uri categoryUri);
}
