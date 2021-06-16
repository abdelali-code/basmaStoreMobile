package com.example.basmaonline.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basmaonline.ProductDetails;
import com.example.basmaonline.R;
import com.example.basmaonline.models.Product;
import com.google.android.material.card.MaterialCardView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    private Context context;
    private List<Product> products;
    private Class<ProductDetails> targetContext;

    public RecycleViewAdapter(Context context, List<Product> products, Class<ProductDetails> targetContext) {
        this.context = context;
        this.products = products;
        this.targetContext = targetContext;
    }
    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        // here LayoutInflater is used to convert the R.layout.fr... into an view object
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_card_layout, parent, false);
        return new MyViewHolder(view, products, context, targetContext);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder myViewHolder, int position) {
        Product destination = products.get(position);
        myViewHolder.setData(destination, position);
    }

    // modify data when it fetched from the server
    public void modifyData(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView cards_title;
        private final ImageView image_view;
        private final Button add_to_check_card, prds_details;

        // because we are not in an activity we can't pass the class to the intent
        // for that we need to pass it like a params to the RecycleViewAdapter and for MyViewHolder
        public MyViewHolder(@NonNull @NotNull View itemView, List<Product> products, Context context, Class<ProductDetails> targetContext) {
            super(itemView);
            image_view = itemView.findViewById(R.id.prds_image);
            cards_title = itemView.findViewById(R.id.crds_title);
            add_to_check_card = itemView.findViewById(R.id.add_prds);
            prds_details = itemView.findViewById(R.id.details_prds);

            Context finalContext = context;
            Class<ProductDetails> productDetailsClass = targetContext;
            prds_details.setOnClickListener(e -> {
               int pos = getAdapterPosition();
               Product selectedProdut = products.get(pos);
               Intent intent = new Intent(finalContext, targetContext);
               intent.putExtra("selectedPrds", selectedProdut);
               finalContext.startActivity(intent);
                System.out.println(selectedProdut.getName());

            });
        }

        public void setData(Product destination, int position) {
            //image_view.setImageURI(Uri.parse(destination.getProductImages().get(0)));
            cards_title.setText(destination.getName());
        }
    }

    public void notifyAdapter() {
        notifyDataSetChanged();
    }
}
