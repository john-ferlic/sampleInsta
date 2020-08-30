package com.example.sampleinstagram.apicallsretro;

import com.example.sampleinstagram.models.User;
import retrofit2.Call;

public class CallManager {

    private static CallManager sCallManager;
    APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

    private CallManager(){}

    public static CallManager getInstance() {
        if (sCallManager == null) {
            sCallManager = new CallManager();
        }
        return sCallManager;
    }

    public Call<User> requestUserInfo(){
        Call<User> call = apiInterface.getUser();
        return call;
    }
}
