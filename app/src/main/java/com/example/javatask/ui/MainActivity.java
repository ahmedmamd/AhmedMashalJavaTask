package com.example.javatask.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.javatask.R;
import com.example.javatask.adapter.PopularStareAdapter;
import com.example.javatask.databinding.ActivityMainBinding;
import com.example.javatask.pojo.Items;
import com.example.javatask.repository.HomeRepository;
import com.example.javatask.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    HomeViewModel homeViewModel = new HomeViewModel();
    PopularStareAdapter popularStarAdapter ;
    ArrayList<Items> itemList =new ArrayList<>();

    private static final String[] COUNTRIES = new String[] {
            "top 10",
            "top 50",
            "top 100",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        setUpUi();
        setUpObserver();
    }

    private void setUpUi() {
        homeViewModel.getPopularStar(this);
        popularStarAdapter = new PopularStareAdapter(this ,itemList, 10);
        binding.psRec.setLayoutManager(new LinearLayoutManager(this));
        binding.psRec.setAdapter(popularStarAdapter);
        // add spinner
        ArrayAdapter<String>  spinnerTopItems = new ArrayAdapter<String> (
                this, android.R.layout.simple_spinner_item, COUNTRIES);
        binding.topStar.setAdapter(spinnerTopItems);

        // choice from spinner
        binding.topStar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("top 10")){
                    homeViewModel.getPopularStar(getApplicationContext());
                    popularStarAdapter = new PopularStareAdapter(getApplicationContext() ,itemList, 10);
                    binding.psRec.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    binding.psRec.setAdapter(popularStarAdapter);
                }else if (parent.getItemAtPosition(position).toString().equals("top 50")){
                    homeViewModel.getPopularStar(getApplicationContext());
                    popularStarAdapter = new PopularStareAdapter(getApplicationContext() ,itemList, 50);
                    binding.psRec.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    binding.psRec.setAdapter(popularStarAdapter);
                }else  if (parent.getItemAtPosition(position).toString().equals("top 100")){
                    homeViewModel.getPopularStar(getApplicationContext());
                    popularStarAdapter = new PopularStareAdapter(getApplicationContext() ,itemList, 100);
                    binding.psRec.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    binding.psRec.setAdapter(popularStarAdapter);
                }
            }
        });
    }

    private void setUpObserver() {
        //observe on Popular Star
        homeViewModel.popularLiveData().observe(this, response -> {
                itemList.clear();
                itemList.addAll(response);
                popularStarAdapter.notifyDataSetChanged();
        });
    }
}