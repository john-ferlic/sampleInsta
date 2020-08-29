package com.example.sampleinstagram.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sampleinstagram.R;
import com.example.sampleinstagram.managers.MemoryManager;
import com.example.sampleinstagram.presenters.CreateUserPresenter;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = CreateAccountActivity.class.getSimpleName();

    EditText name;
    EditText pass;
    EditText pass2;
    CreateUserPresenter createUserPresenter;
    MemoryManager memoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        setUpView();
        memoryManager = new MemoryManager(this);
        memoryManager.isValidUser("x", "y");
    }

    public void setUpView() {
        name = findViewById(R.id.editTextUserName);
        pass = findViewById(R.id.editTextPassword);
        pass2 = findViewById(R.id.editTextReenterPassword);
        Button loginButton = findViewById(R.id.buttonCreate);
        loginButton.setOnClickListener(this);
        createUserPresenter = new CreateUserPresenter();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCreate:
                String user = name.getText().toString();
                String password = pass.getText().toString();
                if (createUserPresenter.isValidCredentials(user, password, pass2.getText().toString())) {
                    memoryManager.addUser(user, password);
                    Toast.makeText(getApplicationContext(), "Account Created!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Enter Valid Credentials", Toast.LENGTH_SHORT).show();
                }
        }
    }
}