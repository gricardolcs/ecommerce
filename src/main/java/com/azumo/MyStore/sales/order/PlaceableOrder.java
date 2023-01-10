package com.azumo.MyStore.sales.order;

public interface PlaceableOrder extends Order{

    void place();

    final class OrderAlreadyPlacedException extends IllegalStateException {}

}

