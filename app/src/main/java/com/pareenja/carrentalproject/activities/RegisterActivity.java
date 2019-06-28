package com.pareenja.carrentalproject.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.pareenja.carrentalproject.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mFirstNameEditText;
    EditText mLastNameEditText;
    EditText mEmailEditText;
    EditText mPhoneNumberEditText;
    EditText mPasswordEditText;
    EditText mConfirmPasswordEditText;
    Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initLayout();
    }

    private void initLayout() {
        mFirstNameEditText = findViewById(R.id.edit_text_first_name);
        mLastNameEditText = findViewById(R.id.edit_text_last_name);
        mEmailEditText = findViewById(R.id.edit_text_email);
        mPhoneNumberEditText = findViewById(R.id.edit_text_phone);
        mPasswordEditText = findViewById(R.id.edit_text_password);
        mConfirmPasswordEditText = findViewById(R.id.edit_text_confirm_password);
        mRegisterButton = findViewById(R.id.button_register);

        mRegisterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_register) {

        }
    }
}
