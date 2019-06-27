package com.pareenja.carrentalproject.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pareenja.carrentalproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCarFragment extends Fragment implements View.OnClickListener {


    private EditText vinEditText;
    private EditText modelEditText;
    private EditText brandEditText;
    private EditText colorEditText;
    private Button buttonAddCar;

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
        buttonAddCar = view.findViewById(R.id.button_add_car);

        buttonAddCar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

    }
}
