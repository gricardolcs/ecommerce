package com.azumo.MyStore.sales.cart;

import com.azumo.MyStore.sales.cart.item.CartItem;
import com.azumo.MyStore.sales.cart.item.ProductId;

import java.util.List;

/**
 * Cart entity.
 */
public interface Cart {

    CartId id();

    List<CartItem> items();

    boolean hasItems();

    void add(CartItem toAdd);

    void remove(ProductId productId);

    void empty();
}
