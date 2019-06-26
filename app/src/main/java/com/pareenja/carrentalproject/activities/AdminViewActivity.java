package com.pareenja.carrentalproject.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.pareenja.carrentalproject.R;
import com.pareenja.carrentalproject.fragments.AddCarFragment;
import com.pareenja.carrentalproject.fragments.AdminActionFragment;
import com.pareenja.carrentalproject.fragments.ManageCarsFragment;
import com.pareenja.carrentalproject.interfaces.AdminActionListener;

public class AdminViewActivity
        extends AppCompatActivity
        implements AdminActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);

        AdminActionFragment adminActionFragment = new AdminActionFragment();
        displayNewFragment(R.id.frame_admin,
                adminActionFragment,
                getString(R.string.admin_action_fragment),
                false);
    }

    @Override
    public void addFragment(String string) {
        switch (string) {
            case "cars":
                ManageCarsFragment manageCarsFragment = new ManageCarsFragment();
                displayNewFragment(R.id.frame_admin,
                        manageCarsFragment,
                        getString(R.string.manage_cars_fragment),
                        true);
                break;

            case "employees":
                break;

            case "users":
                break;

            case "add car":
                AddCarFragment addCarFragment = new AddCarFragment();
                displayNewFragment(R.id.frame_admin,
                        addCarFragment,
                        getString(R.string.add_car_fragment),
                        true);
                break;
        }
    }

    public void displayNewFragment(int layoutId, Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(layoutId, fragment, tag);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }

        fragmentTransaction.commit();
    }
}
