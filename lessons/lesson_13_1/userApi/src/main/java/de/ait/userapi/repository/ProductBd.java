package de.ait.userapi.repository;

import de.ait.userapi.model.Product;

import java.util.HashMap;
import java.util.List;

public class ProductBd {
    private Long lastId;
    private static HashMap<Long, Product> products = new HashMap<>();

    public List<Product> findAll() {
        return products.values().stream().toList();
    }


    public Product findById(Long id) {
        return products.get(id);
    }

    public Product save(Product product) {
        product.setId(++lastId);
        products.put(product.getId(),product);
        return product;
    }
}
