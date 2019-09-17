package com.example.myapplication;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Movie;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.myapplication.viewmodel.MainActivityViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private UserAdapter adapter;

    private List<User.Datum> datumList;

    private MainActivityViewModel mainActivityViewModel;

    RecyclerView rv;
    ProgressBar progressBar;

    private static final int PAGE_START = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int TOTAL_PAGES;
    private int currentPage = PAGE_START;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        init();

    }

    private void init() {


        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);


        mainActivityViewModel.getUserMutableLiveData().observe(this, userList->{


            if (adapter==null){
                datumList=userList;
                adapter = new UserAdapter(this, datumList);
                rv.setAdapter(adapter);
            }else {
                datumList.addAll(userList);
                adapter.notifyDataSetChanged();
            }
        });

        rv.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;

                mainActivityViewModel.init();

            }

            @Override
            public int getTotalPageCount() {
                return TOTAL_PAGES;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

        mainActivityViewModel.init();


    }

    private void findView() {
        rv = (RecyclerView) findViewById(R.id.main_recycler);
        progressBar = (ProgressBar) findViewById(R.id.main_progress);
    }




}
