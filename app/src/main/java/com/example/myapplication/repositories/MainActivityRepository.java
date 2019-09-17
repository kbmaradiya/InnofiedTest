package com.example.myapplication.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.example.myapplication.NetworkClient;
import com.example.myapplication.NetworkInterface;
import com.example.myapplication.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivityRepository {

    private static MainActivityRepository mainActivityRepository;

    private Retrofit retrofit;
    private NetworkInterface networkInterface;


    public static MainActivityRepository getInstance() {
        if (mainActivityRepository==null){
            mainActivityRepository=new MainActivityRepository();
        }
        return mainActivityRepository;
    }

    public void getUserList(int currentPage, final MutableLiveData<List<User.Datum>> userMutableLiveData, final MutableLiveData<Boolean> progressMutableLiveData){


        progressMutableLiveData.setValue(true);
        retrofit = NetworkClient.getRetrofit();
        networkInterface = retrofit.create(NetworkInterface.class);

        Call<User> userCall = networkInterface.getMovies(currentPage, 5);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response != null && response.body().getData().size() > 0) {
//                    TOTAL_PAGES = response.body().getTotalPages();
                     userMutableLiveData.setValue(response.body().getData());
                  progressMutableLiveData.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                progressMutableLiveData.setValue(false);
            }
        });


    }
}
