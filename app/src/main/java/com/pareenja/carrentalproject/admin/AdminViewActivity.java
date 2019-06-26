package com.pareenja.carrentalproject.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.pareenja.carrentalproject.R;

public class AdminViewActivity
        extends AppCompatActivity
        implements AdminActionFragment.AdminActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);

        AdminActionFragment adminActionFragment = new AdminActionFragment();
        displayNewFragment(R.id.frame_admin,
                adminActionFragment,
                getResources().getString(R.string.admin_action_fragment),
                false);
    }

    @Override
    public void addFragment(String string) {
        switch (string) {
            case "cars":
                ManageCarsFragment manageCarsFragment = new ManageCarsFragment();
                displayNewFragment(R.id.frame_admin,
                        manageCarsFragment,
                        getResources().getString(R.string.manage_cars_fragment),
                        true);


                break;
            case "employees":
                break;
            case "users":
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
