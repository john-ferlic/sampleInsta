package com.example.sampleinstagram.managers;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class MemoryManager {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    private final String DATA = "data";

    public MemoryManager(AppCompatActivity activity) {
        sharedPref = activity.getSharedPreferences(DATA, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public void addUser(String user, String pass) {
        editor.putString(user, pass);
        editor.commit();
    }

    public boolean isValidUser(String user, String pass) {
        Map<String, String> allUsers = (Map<String, String>) sharedPref.getAll();
        for (Map.Entry<String, String> entry: allUsers.entrySet()) {
            if (user.equals(entry.getKey()) && pass.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }
}
