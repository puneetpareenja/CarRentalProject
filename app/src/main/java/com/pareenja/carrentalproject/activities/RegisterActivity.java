package com.pareenja.carrentalproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pareenja.carrentalproject.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mFirstNameEditText;
    EditText mLastNameEditText;
    EditText mEmailEditText;
    EditText mPhoneNumberEditText;
    EditText mPasswordEditText;
    EditText mConfirmPasswordEditText;
    Button mRegisterButton;

    private FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

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

        db = FirebaseFirestore.getInstance();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_register) {
            if (isInformationValid()) {
                mAuth.createUserWithEmailAndPassword(
                        mEmailEditText.getText().toString(),
                        mPasswordEditText.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information


                                    startActivity(
                                            new Intent(
                                                    RegisterActivity.this
                                                    , LoginActivity.class));
                                } else {

                                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                        Toast.makeText(
                                                RegisterActivity.this,
                                                "User Already Exists",
                                                Toast.LENGTH_SHORT)
                                                .show();
                                    }

                                }
                            }
                        });
            }
        }
    }

    private boolean isInformationValid() {
        boolean returnValue = true;

        if (TextUtils.isEmpty(mFirstNameEditText.getText())) {
            mFirstNameEditText.setError("Please enter First Name");
            returnValue = false;
        }

        if (TextUtils.isEmpty(mLastNameEditText.getText())) {
            mLastNameEditText.setError("Please enter Last Name");
            returnValue = false;
        }

        if (TextUtils.isEmpty(mEmailEditText.getText())
                || !Patterns.EMAIL_ADDRESS.matcher(mEmailEditText.getText()).matches()) {
            mEmailEditText.setError("Please enter a valid Email");
            returnValue = false;
        }

        if (TextUtils.isEmpty(mPhoneNumberEditText.getText())) {
//                Patterns.PHONE.matcher(mPhoneNumberEditText.getText()).matches())
            mPhoneNumberEditText.setError("Please enter a valid Phone Number");
            returnValue = false;
        }

        if (TextUtils.isEmpty(mPasswordEditText.getText())) {
            mPasswordEditText.setError("Please enter a Password");
            returnValue = false;
        } else if (mPasswordEditText.getText().toString().length() < 6) {
            mPasswordEditText.setError("Password must have at least 6 characters");
            returnValue = false;
        }

        if (TextUtils.isEmpty(mConfirmPasswordEditText.getText())) {
            mConfirmPasswordEditText.setError("Please confirm your password");
            returnValue = false;
        } else if (!mPasswordEditText.getText().toString()
                .equalsIgnoreCase(mConfirmPasswordEditText.getText().toString())) {
            mConfirmPasswordEditText.setError("Passwords don't match");
            returnValue = false;
        }

        return returnValue;
    }
}
