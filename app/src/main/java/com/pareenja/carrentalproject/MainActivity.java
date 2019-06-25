package com.pareenja.carrentalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mUserNameEditText;
    EditText mPasswordEditText;
    Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
    }

    private void initLayout() {
        mUserNameEditText = findViewById(R.id.edit_text_username);
        mPasswordEditText = findViewById(R.id.edit_text_password);
        mLoginButton = findViewById(R.id.button_login);

        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                Intent intent = new Intent(this, AdminViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
