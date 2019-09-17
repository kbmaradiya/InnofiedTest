package com.example.myapplication;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {

    @GET("users")
    Call<User> getMovies(@Query("page") int page, @Query("per_page") int perPage);
}
