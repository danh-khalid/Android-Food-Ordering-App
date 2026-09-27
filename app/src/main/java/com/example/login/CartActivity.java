package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private LinearLayout cartLayout;
    private TextView totalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartLayout = findViewById(R.id.cart_layout);
        totalText = findViewById(R.id.total_price);

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());

        showCartItems();
    }

    private void showCartItems() {
        cartLayout.removeAllViews();

        List<Product> cart = CartManager.getCart();

        for (int i = 0; i < cart.size(); i++) {
            Product product = cart.get(i);

            View itemView = getLayoutInflater().inflate(R.layout.item_product_cart, cartLayout, false);

            TextView name = itemView.findViewById(R.id.name);
            TextView price = itemView.findViewById(R.id.price);
            ImageView image = itemView.findViewById(R.id.image);
            Button deleteBtn = itemView.findViewById(R.id.delete_button);

            name.setText(product.getName());
            price.setText(product.getPrice() + " دينار");
            image.setImageResource(product.getImageResId());

            int index = i;
            deleteBtn.setOnClickListener(v -> {
                CartManager.removeFromCart(index);
                showCartItems();
            });

            cartLayout.addView(itemView);
        }

        totalText.setText("المجموع: " + CartManager.getTotal() + " دينار");
    }
}
