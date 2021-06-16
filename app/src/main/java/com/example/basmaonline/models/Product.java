package com.example.basmaonline.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Product implements Parcelable {
    private long id;

    private String name;

    private double price;

    private int discount;

    private String description;


    protected List<String> productImages = new ArrayList<>();

    private String category;

    public Product() {}

    public Product(long id, String name, double price, int discount, String description, List<String> productImages, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.productImages = productImages;
        this.category = category;
    }


    protected Product(Parcel in) {
        id = in.readLong();
        name = in.readString();
        price = in.readDouble();
        discount = in.readInt();
        description = in.readString();
        productImages = in.createStringArrayList();
        category = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<String> productImages) {
        this.productImages = productImages;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(id);
        dest.writeString(description);
        dest.writeInt(discount);
        dest.writeDouble(price);
        dest.writeString(category);
        dest.writeStringList(productImages);
    }
}
