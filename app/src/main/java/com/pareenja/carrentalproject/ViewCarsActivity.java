package com.pareenja.carrentalproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class ViewCarsActivity extends AppCompatActivity {

    FirebaseFirestore db;
    private static final String TAG = "ViewCarsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cars);

        db = FirebaseFirestore.getInstance();
    }
}
