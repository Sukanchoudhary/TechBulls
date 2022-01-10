package com.example.techbulls.network;

import com.example.techbulls.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiClientsService {


    @GET("?apikey=44bb3133")
    Call<MovieModel> moiveDetails(
            @Query("s") String name

    );

}
