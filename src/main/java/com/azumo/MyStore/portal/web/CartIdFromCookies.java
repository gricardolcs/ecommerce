package com.azumo.MyStore.portal.web;

import com.azumo.MyStore.sales.cart.CartId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.UUID;

/**
 * Retrieve and save Cart ID from/to HTTP cookies.
 */
@RequiredArgsConstructor
final class CartIdFromCookies {

    private final static String COOKIE_NAME = "CART_ID";

    private final @NonNull HttpServletRequest request;
    private final @NonNull HttpServletResponse response;

    private CartId cartId;

    public CartId cartId() {
        if (cartId == null) {
            cartId = new CartId(
                    request.getCookies() != null ?
                    Arrays.stream(request.getCookies())
                            .filter(cookie -> COOKIE_NAME.equalsIgnoreCase(cookie.getName()))
                            .map(Cookie::getValue)
                            .findAny()
                            .orElseGet(() -> UUID.randomUUID().toString())
                    : UUID.randomUUID().toString());

            saveCookie(cartId.value());
        }
        return cartId;
    }

    private void saveCookie(String value) {
        response.addCookie(asCookie(COOKIE_NAME, value));
    }

    private Cookie asCookie(String name, String value) {
        var cookie = new Cookie(name, value);
        cookie.setPath("/");
        return cookie;
    }
}
