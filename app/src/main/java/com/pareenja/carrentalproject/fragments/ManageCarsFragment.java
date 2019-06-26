package com.pareenja.carrentalproject.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.pareenja.carrentalproject.R;
import com.pareenja.carrentalproject.interfaces.AdminActionListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManageCarsFragment extends Fragment implements View.OnClickListener {

    private AdminActionListener adminActionListener;

    public ManageCarsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manage_cars, container, false);
        initFragment(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            adminActionListener = (AdminActionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement AdminActionListener");
        }
    }

    private void initFragment(View view) {
        Button addNewCarButton = view.findViewById(R.id.button_add_car);
        addNewCarButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_add_car) {
            adminActionListener.addFragment("add car");
        }
    }
}
