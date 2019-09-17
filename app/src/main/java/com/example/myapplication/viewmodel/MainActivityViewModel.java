package com.example.myapplication.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.myapplication.User;
import com.example.myapplication.repositories.MainActivityRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private int PAGE=1;

    private MutableLiveData<List<User.Datum>> userMutableLiveData;
    private MutableLiveData<Boolean> progressMutableLiveData;

    public MutableLiveData<List<User.Datum>> getUserMutableLiveData() {
        if (userMutableLiveData==null){
            userMutableLiveData=new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public MutableLiveData<Boolean> getProgressMutableLiveData() {

        if (progressMutableLiveData==null){
            progressMutableLiveData=new MutableLiveData<>();
        }
        return progressMutableLiveData;
    }

    public void init(){
        MainActivityRepository.getInstance().getUserList(PAGE,getUserMutableLiveData(),getProgressMutableLiveData());
    }
}
