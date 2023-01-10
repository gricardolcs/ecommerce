package com.azumo.MyStore.shipping.delivery.jdbc;

import com.azumo.MyStore.shipping.delivery.DeliveryId;
import com.azumo.MyStore.shipping.delivery.DeliveryInfo;
import com.azumo.MyStore.shipping.delivery.DeliveryInfos;
import com.azumo.MyStore.shipping.delivery.OrderId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;
import java.util.stream.Stream;

/**
 * JDBC implementation of Delivery Infos collection.
 */
@RequiredArgsConstructor
final class DeliveryInfosJdbc implements DeliveryInfos {

    private final @NonNull String query;

    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public Stream<DeliveryInfo> stream() {
        return jdbcTemplate.queryForList(query.concat(" ORDER BY 1"))
                .stream()
                .map(this::toDeliveryInfo);
    }

    private DeliveryInfo toDeliveryInfo(Map<String, Object> entry) {
        return new DeliveryInfo(
                new DeliveryId(entry.get("id")),
                new OrderId(entry.get("orderId")));
    }
}
