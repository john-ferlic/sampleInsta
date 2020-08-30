package com.example.sampleinstagram.apicallsretro;


import com.example.sampleinstagram.models.User;
import com.example.sampleinstagram.models.UserList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @GET("/api/users/2")
    Call<User> getUser();


}
