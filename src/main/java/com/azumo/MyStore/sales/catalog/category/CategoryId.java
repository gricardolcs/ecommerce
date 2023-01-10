package com.azumo.MyStore.sales.catalog.category;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class CategoryId {

    private final @NonNull String id;

    public CategoryId(@NonNull Object id){
        var idVal = id.toString().strip();
        if (idVal.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty!");
        }
        this.id = idVal;
    }
    public String value(){return id;}
}
