package com.example.basmaonline.service;

import com.example.basmaonline.models.Product;
import com.example.basmaonline.models.ProductsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductService {

    @GET("products")
    Call<List<Product>> getProducts();

    @POST("products")
    Call<Product> addProducts(@Body Product product);

    @PUT("products/{id}")
    Call<Product> updateProducts(@Path("id") long id);

    @DELETE("products/{id}")
    void deleteProducts(@Path("id") long id);
}
