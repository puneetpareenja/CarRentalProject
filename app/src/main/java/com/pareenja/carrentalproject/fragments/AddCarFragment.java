package com.pareenja.carrentalproject.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pareenja.carrentalproject.R;
import com.pareenja.carrentalproject.models.Car;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCarFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "AddCarFragment";
    private EditText vinEditText;
    private EditText modelEditText;
    private EditText brandEditText;
    private EditText colorEditText;
    private EditText capacityEditText;
    private EditText pricePerHourEditText;
    private EditText pricePerDayEditText;

    private FirebaseFirestore firebaseFirestore;

    public AddCarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_car, container, false);
        initFragment(view);
        return view;
    }

    private void initFragment(View view) {
        vinEditText = view.findViewById(R.id.edit_text_vin);
        modelEditText = view.findViewById(R.id.edit_text_model);
        brandEditText = view.findViewById(R.id.edit_text_brand);
        colorEditText = view.findViewById(R.id.edit_text_color);
        capacityEditText = view.findViewById(R.id.edit_text_capacity);
        pricePerHourEditText = view.findViewById(R.id.edit_text_price_per_hour);
        pricePerDayEditText = view.findViewById(R.id.edit_text_price_per_day);
        Button buttonAddCar = view.findViewById(R.id.button_add_car);

        buttonAddCar.setOnClickListener(this);

        makeEditTextClearOnClick(vinEditText);
        makeEditTextClearOnClick(modelEditText);
        makeEditTextClearOnClick(brandEditText);
        makeEditTextClearOnClick(colorEditText);
        makeEditTextClearOnClick(capacityEditText);
        makeEditTextClearOnClick(pricePerDayEditText);
        makeEditTextClearOnClick(pricePerHourEditText);

        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    private void makeEditTextClearOnClick(final EditText editText) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editText.setText("");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_add_car) {
            final Car car = new Car();
            car.setVinNumber(vinEditText.getText().toString());
            car.setBrand(brandEditText.getText().toString());
            car.setCarModel(modelEditText.getText().toString());
            car.setColor(colorEditText.getText().toString());
            car.setCapacity(Integer.parseInt(capacityEditText.getText().toString()));
            car.setPricePerHour(Double.parseDouble(pricePerHourEditText.getText().toString()));
            car.setPricePerDay(Double.parseDouble(pricePerDayEditText.getText().toString()));

            firebaseFirestore
                    .collection("cars")
                    .add(car)
                    .addOnSuccessListener(
                            new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getContext(),
                                            car.getBrand() + " " + car.getCarModel() + " Added",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getContext(),
                                    e.getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
