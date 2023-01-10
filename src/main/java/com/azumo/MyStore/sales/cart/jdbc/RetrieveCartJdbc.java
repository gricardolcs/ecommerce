package com.azumo.MyStore.sales.cart.jdbc;

import com.azumo.MyStore.sales.cart.Cart;
import com.azumo.MyStore.sales.cart.CartId;
import com.azumo.MyStore.sales.cart.RetrieveCart;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Retrieve Cart use-cases.
 */
@RequiredArgsConstructor
class RetrieveCartJdbc implements RetrieveCart {

    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public Cart byId(CartId cartId) {
        return new CartJdbc(cartId, jdbcTemplate);
    }
}
