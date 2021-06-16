package com.example.basmaonline.repository;

import com.example.basmaonline.models.Product;
import com.example.basmaonline.models.ProductsList;
import com.example.basmaonline.service.ProductService;
import com.example.basmaonline.servicebuilder.ServiceBuilder;

import java.util.List;

import retrofit2.Call;

public class ProductRepository {
    private ProductService productService;

    public ProductRepository() {
        this.productService = ServiceBuilder.buildService(ProductService.class);
    }

    public Call<List<Product>> getAllProducts() {
        return productService.getProducts();
    }

    public Call<Product> addProducts(Product product) {
        return productService.addProducts(product);
    }

    public void deleteProducts(long id) {
        productService.deleteProducts(id);
    }
}
