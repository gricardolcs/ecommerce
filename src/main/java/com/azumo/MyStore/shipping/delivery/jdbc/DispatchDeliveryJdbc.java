package com.azumo.MyStore.shipping.delivery.jdbc;

import com.azumo.MyStore.shipping.delivery.Delivery;
import com.azumo.MyStore.shipping.delivery.DispatchDelivery;
import com.azumo.MyStore.shipping.delivery.FindDeliveries;
import com.azumo.MyStore.shipping.delivery.OrderId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dispatch Delivery use-case.
 */
@RequiredArgsConstructor
public class DispatchDeliveryJdbc implements DispatchDelivery {

    private final @NonNull FindDeliveries findDeliveries;

    /**
     * Dispatches a delivery by the order ID.
     *
     * @param orderId the order ID
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void byOrder(OrderId orderId) {
        Delivery delivery = findDeliveries.byOrder(orderId);
        delivery.dispatch();
    }
}
