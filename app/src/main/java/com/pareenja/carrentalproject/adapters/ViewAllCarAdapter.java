package com.pareenja.carrentalproject.adapters;

import android.annotation.SuppressLint;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.pareenja.carrentalproject.R;
import com.pareenja.carrentalproject.models.Car;

public class ViewAllCarAdapter extends FirestoreRecyclerAdapter<Car, ViewAllCarAdapter.ViewHolder> {


    public ViewAllCarAdapter(@NonNull FirestoreRecyclerOptions<Car> options) {
        super(options);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i, @NonNull Car car) {
        viewHolder.carNameTextView.setText(car.getBrand() + " " + car.getCarModel());
        viewHolder.carColorTextView.setText(car.getColor());
        NumberFormat format = NumberFormat.getCurrencyInstance();

        viewHolder.carPriceTextView.setText(
                format.format(car.getPricePerHour())
                        + " / "
                        + format.format(car.getPricePerDay()));

        viewHolder.parentCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.car_item_view, parent, false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView carImageView;
        TextView carNameTextView;
        TextView carColorTextView;
        TextView carPriceTextView;
        CardView parentCardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            carImageView = itemView.findViewById(R.id.image_view_car_image);
            carNameTextView = itemView.findViewById(R.id.text_view_car_name);
            carColorTextView = itemView.findViewById(R.id.text_view_car_color);
            carPriceTextView = itemView.findViewById(R.id.text_view_car_price);
            parentCardView = itemView.findViewById(R.id.card_view_parent);

        }

    }
}
