package com.azumo.MyStore.sales.order.item;

import com.azumo.MyStore.common.primitives.Quantity;
import lombok.*;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderItem {

    private final @NonNull ProductId productId;
    private final @NonNull Quantity quantity;

    public ProductId productId() {
        return productId;
    }
    public Quantity quantity() {
        return  quantity;
    }
}
