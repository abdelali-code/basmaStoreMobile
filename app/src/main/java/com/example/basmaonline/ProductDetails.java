package com.example.basmaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.basmaonline.models.Product;

public class ProductDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Intent intent = getIntent();
        Product selectedProduct = intent.getParcelableExtra("selectedPrds");
        System.out.println(selectedProduct.getName() + " from the products details");
    }
}