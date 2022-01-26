package com.example.javatask.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.javatask.R;

public class Utils {
    @BindingAdapter("imageBinding")
    public static void bindUser(ImageView view, String imageUrl) {
        Glide.with(view)
                .load(imageUrl)
                .placeholder(R.drawable.defult_img)
                .into(view);
    }
}

