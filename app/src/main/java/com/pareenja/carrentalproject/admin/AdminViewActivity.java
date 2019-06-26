package com.pareenja.carrentalproject.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pareenja.carrentalproject.R;

public class AdminViewActivity
        extends AppCompatActivity
        implements AdminActionFragment.AdminActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);

        AdminActionFragment adminActionFragment = new AdminActionFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_admin,
                        adminActionFragment,
                        getResources().getString(R.string.admin_action_fragment))
                .commit();
    }

    @Override
    public void addFragment(String string) {

    }
}
