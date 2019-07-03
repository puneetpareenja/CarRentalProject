package com.pareenja.carrentalproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pareenja.carrentalproject.R;
import com.pareenja.carrentalproject.models.Person;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mUserNameEditText;
    EditText mPasswordEditText;
    Button mLoginButton;
    TextView mRegisterTextView;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

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
                mAuth.signInWithEmailAndPassword(
                        mUserNameEditText.getText().toString(),
                        mPasswordEditText.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {

                                String Uid = authResult.getUser().getUid();

                                DocumentReference documentReference
                                        = FirebaseFirestore.getInstance()
                                        .collection("users")
                                        .document(Uid);


                                documentReference.get()
                                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                            @Override
                                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                Person person = documentSnapshot.toObject(Person.class);
                                                goToActivityForPerson(person);
                                            }
                                        });


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                break;

            case R.id.text_view_register:
                Intent intentToRegister = new Intent(this, RegisterActivity.class);
                startActivity(intentToRegister);
                break;
        }
    }

    public void goToActivityForPerson(Person person) {
        if (person != null) {
            Intent intent;
            switch (person.getPersonType()) {
                case CUSTOMER:
                    intent = new Intent(LoginActivity.this, ViewCarsActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    break;
                case SALESPERSON:

                    break;
                case ADMINISTRATOR:
                    intent = new Intent(LoginActivity.this, AdminViewActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    }
}
