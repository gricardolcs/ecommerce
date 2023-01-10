package com.azumo.MyStore.sales.catalog;

import com.azumo.MyStore.sales.catalog.product.Product;
import com.azumo.MyStore.sales.catalog.product.Products;
import com.azumo.MyStore.sales.order.item.ProductId;

public interface FindProducts {

    Products all();

    Product byId(ProductId id);
}
