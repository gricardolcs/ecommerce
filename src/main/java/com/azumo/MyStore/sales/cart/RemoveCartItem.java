package com.azumo.MyStore.sales.cart;

import com.azumo.MyStore.sales.cart.item.ProductId;

/**
 * Remove Cart Item use-case.
 */
public interface RemoveCartItem {

    /**
     * Removes the item from the cart.
     *
     * @param cartId    the cart ID
     * @param productId the product ID to remove
     */
    void fromCart(CartId cartId, ProductId productId);
}
