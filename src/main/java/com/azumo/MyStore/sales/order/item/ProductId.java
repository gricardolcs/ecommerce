package com.azumo.MyStore.sales.order.item;

import lombok.NonNull;

public class ProductId {

    private final @NonNull String id;

    public ProductId(@NonNull Object id){
        var idVal = id.toString().strip();
        if (idVal.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty!");
        }
        this.id = idVal;
    }
    public String value(){ return id;}
}
