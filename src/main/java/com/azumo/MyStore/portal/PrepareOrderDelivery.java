package com.azumo.MyStore.portal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PrepareOrderDelivery {

    private final @NonNull PrepareOrderDelivery prepareOrderDelivery;

    public void setPrepareOrderDelivery(@NonNull UUID orderId, @NonNull Address address){
        prepareDelivery.prepare(new OrderId(orderId), address);
    }
}
