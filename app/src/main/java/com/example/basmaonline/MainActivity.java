package com.example.basmaonline;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.basmaonline.adapter.RecycleViewAdapter;
import com.example.basmaonline.models.Product;
import com.example.basmaonline.viewsModel.ProductViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.R)
public class MainActivity extends AppCompatActivity {

    private RecyclerView recycle_view_prds;
    private RecycleViewAdapter recycleViewAdapter;
    private List<Product> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle_view_prds = findViewById(R.id.recycle_view_prds);
        ProductViewModel model = new ViewModelProvider(this).get(ProductViewModel.class);


        model.getProductsMutableData().observe(this, pdrs -> {
            recycleViewAdapter = new RecycleViewAdapter(this, pdrs, ProductDetails.class);
            recycle_view_prds.setLayoutManager(new LinearLayoutManager(this));
            recycle_view_prds.setAdapter(recycleViewAdapter);
        });
    }
}