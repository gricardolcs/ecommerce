package com.azumo.MyStore.portal;

import com.azumo.MyStore.sales.order.PlaceOrder;
import com.azumo.MyStore.shipping.delivery.PrepareDelivery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for Portal component.
 */
@Configuration
class PortalConfig {

    @Bean
    PlaceOrderFromCart placeOrderFromCart(PlaceOrder placeOrder) {
        return new PlaceOrderFromCart(placeOrder);
    }

    @Bean
    PrepareOrderDelivery prepareOrderDelivery(PrepareDelivery prepareDelivery) {
        return new PrepareOrderDelivery(prepareDelivery);
    }
}
