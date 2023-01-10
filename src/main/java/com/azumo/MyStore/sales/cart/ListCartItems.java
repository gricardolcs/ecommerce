package com.azumo.MyStore.sales.cart;

import com.azumo.MyStore.sales.cart.item.CartItem;

import java.util.List;

public interface ListCartItems {

    List<CartItem> listCard(CartId cartId);
}
