package com.azumo.MyStore.sales.cart;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class CartId {
    private final @NonNull String id;

    public CartId(@NonNull Object id) {
        var idVal = id.toString().strip();
        if (idVal.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty!");
        }
        this.id = idVal;
    }

    public String value() {
        return id;
    }

}
