package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Button backBtn = findViewById(R.id.btn_back);
        backBtn.setOnClickListener(v -> finish());

        product = getIntent().getParcelableExtra("product");

        TextView name = findViewById(R.id.detail_name);
        TextView price = findViewById(R.id.detail_price);
        TextView description = findViewById(R.id.detail_description);
        ImageView image = findViewById(R.id.detail_image);
        Button addToCart = findViewById(R.id.add_to_cart);
        Button goToCart = findViewById(R.id.go_to_cart);

        if (product != null) {
            name.setText(product.getName());
            price.setText(String.format("%.2f دينار", product.getPrice()));
            description.setText(product.getDescription());
            image.setImageResource(product.getImageResId());
        } else {
            Toast.makeText(this, "لم يتم استلام بيانات المنتج", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        addToCart.setOnClickListener(v -> {
            CartManager.addToCart(product);
            Toast.makeText(this, "تمت الإضافة إلى السلة", Toast.LENGTH_SHORT).show();
        });

        goToCart.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, CartActivity.class);
            startActivity(intent);
        });
        Button BtnBack= findViewById(R.id.btn_back);
        backBtn.setOnClickListener(v -> finish());

    }
}
