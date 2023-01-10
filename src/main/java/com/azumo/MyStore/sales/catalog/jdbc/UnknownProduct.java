package com.azumo.MyStore.sales.catalog.jdbc;

import com.azumo.MyStore.common.primitives.Money;
import com.azumo.MyStore.sales.catalog.category.CategoryId;
import com.azumo.MyStore.sales.catalog.product.Description;
import com.azumo.MyStore.sales.catalog.product.Product;
import com.azumo.MyStore.sales.catalog.product.ProductId;
import com.azumo.MyStore.sales.catalog.product.Title;
import lombok.ToString;

@ToString
final class UnknownProduct implements Product {


    @Override
    public ProductId id() {
        return new ProductId(0);
    }
    @Override
    public Title title() {
        return new Title("unknown product");
    }
    @Override
    public Description description() {
        return new Description("This product is not to be found.");
    }

    @Override
    public Money price() {
        return new Money(0.0f);
    }

    @Override
    public void changeTitle(Title title) {}
    @Override
    public void changeDescription(Description description) {}
    @Override
    public void changePrice(Money price) {}
    @Override
    public void putForSale() {}
    @Override
    public void categorize(CategoryId categoryId) {}
}