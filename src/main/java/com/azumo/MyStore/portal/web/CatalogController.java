package com.azumo.MyStore.portal.web;

import com.azumo.MyStore.sales.catalog.FindProducts;
import com.azumo.MyStore.sales.catalog.FindProductsFromCategory;
import com.azumo.MyStore.sales.catalog.category.Uri;
import com.azumo.MyStore.sales.catalog.product.Product;
import com.azumo.MyStore.warehouse.InStock;
import com.azumo.MyStore.warehouse.ProductId;
import com.azumo.MyStore.warehouse.Warehouse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * Web controller for Catalog use-cases.
 */
@Controller
@RequiredArgsConstructor
class CatalogController {

    private static final int MAX_RESULTS = 10;

    private final @NonNull FindProducts products;
    private final @NonNull FindProductsFromCategory fromCategory;
    private final @NonNull Warehouse warehouse;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", products.all()
                .range(MAX_RESULTS).stream()
                .map(this::toData)
                .toArray());
        return "catalog";
    }

    @GetMapping("/category/{categoryUri}")
    public String category(@PathVariable @NonNull String categoryUri, Model model) {
        model.addAttribute("products", fromCategory.byUri(new Uri(categoryUri))
                .range(MAX_RESULTS).stream()
                .map(this::toData)
                .toArray());
        return "catalog";
    }

    private Map<String, Object> toData(Product product) {
        return Map.of(
                "id", product.id().value(),
                "title", product.title().value(),
                "description", product.description().value(),
                "price", product.price().value(),
                "inStock", inStock(product).amount().value());
    }

    private InStock inStock(Product product) {
        return warehouse.leftInStock(new ProductId(product.id().value()));
    }
}