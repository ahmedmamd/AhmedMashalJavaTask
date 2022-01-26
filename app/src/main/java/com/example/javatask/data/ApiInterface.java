package com.example.javatask.data;

import com.example.javatask.pojo.PopularStare;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("search/repositories")
    public Observable<PopularStare> popularStar(@Query("q")String q,
                                                @Query("sort")String sort,
                                                @Query("order")String order);

}
