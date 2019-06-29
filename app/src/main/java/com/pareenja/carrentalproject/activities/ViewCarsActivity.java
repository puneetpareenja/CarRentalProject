package com.pareenja.carrentalproject.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.pareenja.carrentalproject.R;
import com.pareenja.carrentalproject.adapters.ViewAllCarAdapter;
import com.pareenja.carrentalproject.models.Car;

import java.util.ArrayList;

public class ViewCarsActivity extends AppCompatActivity {

    private static final String TAG = "ViewCarsActivity";

    ArrayList<Car> carArrayList = new ArrayList<>();
    RecyclerView recyclerView;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference carRef = db.collection("cars");
    private ViewAllCarAdapter viewAllCarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cars);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        Query query = carRef;

        FirestoreRecyclerOptions<Car> carFirestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Car>()
                        .setQuery(query, Car.class)
                        .build();

        viewAllCarAdapter = new ViewAllCarAdapter(carFirestoreRecyclerOptions);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_cars);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(viewAllCarAdapter);

        viewAllCarAdapter.setOnItemClickListener(new ViewAllCarAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                Car car = documentSnapshot.toObject(Car.class);
                String id = documentSnapshot.getId();

                Toast.makeText(ViewCarsActivity.this,
                        "Clicked Item with ID : " + id,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewAllCarAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewAllCarAdapter.stopListening();
    }
}
