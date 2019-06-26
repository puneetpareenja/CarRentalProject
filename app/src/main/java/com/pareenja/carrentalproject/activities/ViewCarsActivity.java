package com.pareenja.carrentalproject.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.pareenja.carrentalproject.R;

public class ViewCarsActivity extends AppCompatActivity {

    private static final String TAG = "ViewCarsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cars);

    }
}
