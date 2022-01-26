package com.example.javatask.repository;

import android.content.Context;

import com.example.javatask.data.ApiInterface;
import com.example.javatask.data.ApiService;
import com.example.javatask.pojo.PopularStare;

import io.reactivex.rxjava3.core.Observable;

public class HomeRepository {
    ApiInterface apiInterface ;

    String q= "created:>2019-01-10";
    String sort = "stars";
    String order = "desc";
      Context context;

    public HomeRepository(Context context) {
        this.context = context;
    }

    public Observable<PopularStare> popular(Context context){
        apiInterface = ApiService.getINSTANCE(context);
        return apiInterface.popularStar(q, sort, order);
    }
}
