package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.Product;
import com.unida.multitoolshop.model.ProductCategory;

import java.util.*;

public interface ProductService {

    List<Product> getAllProducts();
    Product[] getAll();
    Product get(Integer id);
    Product create(Product product);
    Product update(Product product);
    void delete(Integer id);
    Map<String, List<Product>> getCategoryMappedProducts();
    List<ProductCategory> listProductCategories();
}
