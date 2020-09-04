package com.example.sampleinstagram.activities;

import android.os.Bundle;
import android.util.Log;

import com.example.sampleinstagram.R;
import com.example.sampleinstagram.adapters.MainFeedAdapter;
import com.example.sampleinstagram.models.UserList;
import com.example.sampleinstagram.viewmodels.UserListViewModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainFeedActivity extends AppCompatActivity {
    private final String TAG = MainFeedActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private UserListViewModel mUserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_feed);
        setUpView();
    }

    private void setUpView(){
        recyclerView = findViewById(R.id.activity_feed_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mUserList = new ViewModelProvider(this).get(UserListViewModel.class);
        mUserList.getUserList().observe(this, userList -> {
            List<UserList.Datum> datumList = userList.data;
            final MainFeedAdapter adapter = new MainFeedAdapter(datumList);
            recyclerView.setAdapter(adapter);
        });
    }
}