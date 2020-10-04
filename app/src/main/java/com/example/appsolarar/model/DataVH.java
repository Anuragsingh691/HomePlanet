package com.example.appsolarar.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsolarar.R;

public class DataVH extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView textproductName,textProductInfo;
    public ImageView ProductImage;
    public ItemClickListener listener;
    public DataVH(@NonNull View itemView)
    {
        super(itemView);
        ProductImage=(ImageView)itemView.findViewById(R.id.product_img);
        textproductName=(TextView) itemView.findViewById(R.id.product_name);
        textProductInfo=(TextView)itemView.findViewById(R.id.product_desc);
    }

    @Override
    public void onClick(View view) {

    }
}
