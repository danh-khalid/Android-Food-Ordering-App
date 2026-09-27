package com.example.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listView = findViewById(R.id.listView);

        productList = new ArrayList<>();
        productList.add(new Product("بيتزا", R.drawable.petza, 5, "بيتزا بالجبنة."));
        productList.add(new Product("برجر", R.drawable.burger, 2.30, "برجر باللحم."));
        productList.add(new Product("شاورما", R.drawable.shaorma, 6, "شاورما دجاج."));
        productList.add(new Product("معكرونه", R.drawable.nodels, 10, "معكرونه باللحم."));
        productList.add(new Product("قهوة", R.drawable.plainturkishcoffee, 1, "قهوة تركية سادة."));
        productList.add(new Product("سلطة", R.drawable.salad, 3.60, "سلطة جبنة."));
        productList.add(new Product("حلوى", R.drawable.sweet, 4, "حلوى."));

        ProductAdapter adapter = new ProductAdapter(this, productList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity2.this, DetailActivity.class);
            intent.putExtra("product", productList.get(position));
            startActivity(intent);
        });

        Button btnBack = findViewById(R.id.btn_back_to_signup);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, SignupActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
