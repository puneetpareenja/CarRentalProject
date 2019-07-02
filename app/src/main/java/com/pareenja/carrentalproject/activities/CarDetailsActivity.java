package com.pareenja.carrentalproject.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pareenja.carrentalproject.R;
import com.pareenja.carrentalproject.models.Car;

public class CarDetailsActivity extends AppCompatActivity {

    ImageView carImageView;
    TextView carModelTextView;
    TextView carBrandTextView;
    TextView carColorTextView;
    TextView carCapacityTextView;
    TextView carPricePerHours;
    TextView carPricePerDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        Car car = getIntent().getParcelableExtra("car");

        initLayout();
        carModelTextView.setText(car.getCarModel());
        carBrandTextView.setText(car.getBrand());
        carColorTextView.setText(car.getColor());
        carCapacityTextView.setText(String.valueOf(car.getCapacity()));
        carPricePerHours.setText(String.valueOf(car.getPricePerHour()));
        carPricePerDay.setText(String.valueOf(car.getPricePerDay()));
    }

    private void initLayout() {
        carImageView = findViewById(R.id.image_view_car_image);
        carModelTextView = findViewById(R.id.text_view_car_model);
        carBrandTextView = findViewById(R.id.text_view_car_brand);
        carColorTextView = findViewById(R.id.text_view_car_color);
        carCapacityTextView = findViewById(R.id.text_view_car_capacity);
        carPricePerHours = findViewById(R.id.text_view_price_per_hour);
        carPricePerDay = findViewById(R.id.text_view_price_per_day);
    }

}
