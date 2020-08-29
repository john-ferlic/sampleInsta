package com.example.sampleinstagram.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sampleinstagram.R;
import com.example.sampleinstagram.managers.MemoryManager;

import android.view.View.OnClickListener;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements OnClickListener {
    private String TAG = LoginActivity.class.getSimpleName();
    private MemoryManager memoryManager;
    private EditText userEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpView();
        memoryManager = new MemoryManager(this);
    }

    private void setUpView() {
        //Initialize vars
        Button loginButton = findViewById(R.id.loginButton);
        userEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        TextView createAccountText = findViewById(R.id.editTextCreateAccount);

        //Setup listeners
        loginButton.setOnClickListener(this);
        createAccountText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                if (memoryManager.isValidUser(userEditText.getText().toString(), passwordEditText.getText().toString())) {
                    Intent intent = new Intent(this, MainFeedActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "Wrong Username/Password", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "FAILURE");
                }
                break;
            case R.id.editTextCreateAccount:
                Log.d(TAG, "CLICKED ON CREATE AN ACCOUNT");
                Intent intent = new Intent(this, CreateAccountActivity.class);
                startActivity(intent);
                break;
        }
    }
}