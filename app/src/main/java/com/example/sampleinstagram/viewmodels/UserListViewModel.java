package com.example.sampleinstagram.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.sampleinstagram.adapters.MainFeedAdapter;
import com.example.sampleinstagram.apicallsretro.APIClient;
import com.example.sampleinstagram.apicallsretro.APIInterface;
import com.example.sampleinstagram.apicallsretro.CallManager;
import com.example.sampleinstagram.models.UserList;

import java.util.List;

public class UserListViewModel extends ViewModel {
    private final String TAG = UserListViewModel.class.getSimpleName();

    private MutableLiveData<UserList> userList;

    public LiveData<UserList> getUserList() {
        if (userList == null) {
            userList = new MutableLiveData<>();
            loadList();
        }
        return userList;
    }

    private void loadList() {
            CallManager.getInstance().requestUserListInfo("2").enqueue(new Callback<UserList>() {
                @Override
                public void onResponse(Call<UserList> call, Response<UserList> response) {
                    UserList users = response.body();
                    userList.setValue(users);
                }

                @Override
                public void onFailure(Call<UserList> call, Throwable t) {
                    Log.d(TAG, t.toString());
                }
            });
    }



}
