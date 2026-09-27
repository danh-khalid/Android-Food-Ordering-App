package com.example.login;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private String name;
    private int imageResId;
    private double price;
    private String description;


    public Product(String name, int imageResId, double price, String description) {
        this.name = name;
        this.imageResId = imageResId;
        this.price = price;
        this.description = description;
    }

    protected Product(Parcel in) {
        name = in.readString();
        imageResId = in.readInt();
        price = in.readDouble();
        description = in.readString();
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

    // Getters
    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResId);
        dest.writeDouble(price);
        dest.writeString(description);
    }


}
