package com.azumo.MyStore.sales.catalog.product;

import java.util.stream.Stream;

public interface Products {

    Products range(int start, int limit);
    Products range(int limit);

    Stream<Product> stream();
}
