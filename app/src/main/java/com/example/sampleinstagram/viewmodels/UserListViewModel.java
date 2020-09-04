package com.example.sampleinstagram.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sampleinstagram.models.UserList;

public class UserListViewModel {

    private MutableLiveData<UserList> userList;

    public LiveData<UserList> getUserList() {
        if (userList == null) {
            userList = new MutableLiveData<>();
            loadList();
        }
        return userList;
    }

    private void loadList() {

    }



}
