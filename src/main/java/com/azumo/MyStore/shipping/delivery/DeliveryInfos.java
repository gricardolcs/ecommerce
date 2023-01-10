package com.azumo.MyStore.shipping.delivery;

import java.util.stream.Stream;

/**
 * Delivery Info collection.
 */
public interface DeliveryInfos {

    Stream<DeliveryInfo> stream();
}
