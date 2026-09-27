package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private Activity context;
    private List<Product> products;

    public ProductAdapter(Activity context, List<Product> products) {
        super(context, R.layout.item_product, products);
        this.context = context;
        this.products = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_product, parent, false);
        }

        TextView name = rowView.findViewById(R.id.name);
        TextView price = rowView.findViewById(R.id.price);
        ImageView image = rowView.findViewById(R.id.image);

        Product product = products.get(position);
        name.setText(product.getName());
        price.setText(product.getPrice() + " دينار");
        image.setImageResource(product.getImageResId());

        rowView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("product", product);
            context.startActivity(intent);
        });

        return rowView;
    }
}
