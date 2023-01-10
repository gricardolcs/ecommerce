package com.azumo.MyStore.sales.catalog;

import com.azumo.MyStore.sales.catalog.product.Product;
import com.azumo.MyStore.sales.catalog.product.ProductId;
import com.azumo.MyStore.sales.catalog.product.Products;

/**
 * Find Products use-case.
 */
public interface FindProducts {

    /**
     * Lists all products.
     *
     * @return all products
     */
    Products all();

    /**
     * Finds a product by ID.
     *
     * @param id the product ID
     * @return the found product
     */
    Product byId(ProductId id);
}
