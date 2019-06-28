package com.pareenja.carrentalproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pareenja.carrentalproject.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mUserNameEditText;
    EditText mPasswordEditText;
    Button mLoginButton;
    TextView mRegisterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initLayout();


    }

    private void initLayout() {
        mUserNameEditText = findViewById(R.id.edit_text_username);
        mPasswordEditText = findViewById(R.id.edit_text_password);
        mLoginButton = findViewById(R.id.button_login);
        mRegisterTextView = findViewById(R.id.text_view_register);

        mRegisterTextView.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                Intent intent = new Intent(this, AdminViewActivity.class);
                startActivity(intent);
                break;

            case R.id.text_view_register:
                Intent intentToRegister = new Intent(this, RegisterActivity.class);
                startActivity(intentToRegister);
                break;
        }
    }
}
