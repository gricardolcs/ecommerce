package com.azumo.MyStore.warehouse.rest;

import com.azumo.MyStore.warehouse.ProductId;
import com.azumo.MyStore.warehouse.Warehouse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for Warehouse use-cases.
 */
@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
class WarehouseController {

    private final @NonNull Warehouse warehouse;

    @GetMapping("/stock/{productId}")
    public Integer productsInStock(@PathVariable @NonNull String productId) {
        return warehouse.leftInStock(new ProductId(productId)).amount().value();
    }
}
