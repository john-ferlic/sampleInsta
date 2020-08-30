package com.example.sampleinstagram.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.sampleinstagram.R;
import com.example.sampleinstagram.adapters.MainFeedAdapter;
import com.example.sampleinstagram.apicallsretro.APIClient;
import com.example.sampleinstagram.apicallsretro.APIInterface;
import com.example.sampleinstagram.models.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFeedActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainFeedAdapter mAdapter;
    private LinearLayoutManager layoutManager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_feed);
        setUpView();
    }

    private void setUpView(){
        recyclerView = findViewById(R.id.activity_feed_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<UserList> call = apiInterface.doGetUserList("1");
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                UserList userList = response.body();
                List<UserList.Datum> datumList = userList.data;
                final MainFeedAdapter adapter = new MainFeedAdapter(context, datumList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                return;
            }
        });
    }
}