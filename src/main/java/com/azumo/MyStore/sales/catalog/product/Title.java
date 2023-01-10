package com.azumo.MyStore.sales.catalog.product;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EqualsAndHashCode
@ToString
public class Title {

    private final @NonNull String title;

    public Title(@NonNull String title){
        var titleVal = title.strip();
        if (titleVal.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty!");
        }
        this.title = titleVal;
    }
    public String value() {return title;}
}
