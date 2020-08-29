package com.example.sampleinstagram.presenters;

import android.util.Log;

public class CreateUserPresenter {
    private String TAG = CreateUserPresenter.class.getSimpleName();

    public CreateUserPresenter(){}

    public boolean isValidCredentials(String user, String pass, String pass2) {
        return pass.equals(pass2) && !pass.isEmpty() && !pass2.isEmpty() && !user.isEmpty();
    }
}
