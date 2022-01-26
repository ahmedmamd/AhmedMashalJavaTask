package com.example.javatask.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.javatask.base.BaseViewModel;
import com.example.javatask.data.ApiInterface;
import com.example.javatask.data.ApiService;
import com.example.javatask.pojo.Items;
import com.example.javatask.pojo.PopularStare;
import com.example.javatask.repository.HomeRepository;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeViewModel extends BaseViewModel {
    ApiInterface apiInterface;
    HomeRepository homeRepository;
    Context context;

    public HomeViewModel() {
    }

    MutableLiveData<ArrayList<Items>> popularStarMutableLiveData = new MutableLiveData<>();
    public LiveData<ArrayList<Items>> popularLiveData() {
        return popularStarMutableLiveData;
    }

    // get popular star
    public void getPopularStar(Context context){
        apiInterface = ApiService.getINSTANCE(context);
        homeRepository = new HomeRepository(context);
        homeRepository.popular(context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<PopularStare>() {
                               @Override
                               public void onSubscribe(@NonNull Disposable d) {
                               }

                               @Override
                               public void onNext(@NonNull PopularStare popularStare) {
                                   popularStarMutableLiveData.setValue( popularStare.getItems());
                               }

                               @Override
                               public void onError(@NonNull Throwable e) {
                                   Log.e("getPopularStare", "onError: " + e.getMessage());
                               }

                               @Override
                               public void onComplete() {

                               }
                           });
    }
}
