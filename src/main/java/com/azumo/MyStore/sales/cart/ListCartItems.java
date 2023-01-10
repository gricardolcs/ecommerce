package com.azumo.MyStore.sales.cart;

import com.azumo.MyStore.sales.cart.item.CartItem;

import java.util.List;

/**
 * List Cart Items use-case.
 */
public interface ListCartItems {

    /**
     * Lists items in the cart.
     *
     * @param cartId the cart ID
     * @return items in the cart
     */
    List<CartItem> listCart(CartId cartId);
}
