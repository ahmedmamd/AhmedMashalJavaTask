package com.example.javatask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.javatask.R;
import com.example.javatask.databinding.ItemPopularStarBinding;
import com.example.javatask.pojo.Items;
import java.util.ArrayList;

public class PopularStareAdapter extends RecyclerView.Adapter<PopularStareAdapter.PopularStarViewHolder> {

    Context context;
    ArrayList<Items> items;
    int limit;
    public PopularStareAdapter(Context context ,ArrayList<Items> items , int limit ) {
        this.context = context;
        this.items = items;
        this.limit =limit;
    }

    @NonNull
    @Override
    public PopularStarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPopularStarBinding binding;
        binding = DataBindingUtil.inflate(LayoutInflater.from(context) , R.layout.item_popular_star, parent ,false);
        return new PopularStarViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularStarViewHolder holder, int position) {
         holder.binding.setPopularStar(items.get(position));
    }

    @Override
    public int getItemCount() {
        if (items.size() > limit){
            return limit;
        }else{
            return  items.size();
        }
    }

    public class PopularStarViewHolder extends RecyclerView.ViewHolder {
        public ItemPopularStarBinding binding;
        public PopularStarViewHolder(@NonNull ItemPopularStarBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
