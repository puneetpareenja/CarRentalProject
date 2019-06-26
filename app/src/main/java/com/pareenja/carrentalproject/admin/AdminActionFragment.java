package com.pareenja.carrentalproject.admin;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.pareenja.carrentalproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminActionFragment extends Fragment implements View.OnClickListener {

    private AdminActionListener adminActionListener;

    public AdminActionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_action, container, false);
        initFragment(view);
        return view;
    }

    private void initFragment(View view) {
        TextView mTextViewManageCars = view.findViewById(R.id.text_view_manage_cars);
        TextView mTextViewManageEmployees = view.findViewById(R.id.text_view_manage_employees);
        TextView mTextViewManageUsers = view.findViewById(R.id.text_view_manage_users);

        mTextViewManageCars.setOnClickListener(this);
        mTextViewManageEmployees.setOnClickListener(this);
        mTextViewManageUsers.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_view_manage_cars:
                Toast.makeText(getContext(), "Manage Cars", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_view_manage_employees:
                Toast.makeText(getContext(), "Manage Employees", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_view_manage_users:
                Toast.makeText(getContext(), "Manage Users", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            adminActionListener = (AdminActionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    interface AdminActionListener {
        public void addFragment(String string);
    }

}
