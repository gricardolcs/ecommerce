package com.azumo.MyStore.shipping.dispatching.jdbc;

import com.azumo.MyStore.common.events.EventPublisher;
import com.azumo.MyStore.shipping.dispatching.DeliveryDispatched;
import com.azumo.MyStore.shipping.dispatching.Dispatching;
import com.azumo.MyStore.shipping.dispatching.OrderId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@RequiredArgsConstructor
@Slf4j
public class DispatchingJdbc implements Dispatching {

    private final @NonNull EventPublisher eventPublisher;

    @Transactional
    public void dispatch(OrderId orderId) {

        // do the actual dispatching...

        log.info("Order {} is being dispatched.", orderId);

        eventPublisher.raise(new DeliveryDispatched(Instant.now(), orderId.value()));
    }
}
