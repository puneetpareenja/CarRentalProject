package com.pareenja.carrentalproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pareenja.carrentalproject.R;
import com.pareenja.carrentalproject.models.Car;

import java.util.ArrayList;

public class ViewCarsAdapter extends RecyclerView.Adapter<ViewCarsAdapter.ViewHolder> {

    private static final String TAG = "ViewCarsAdapter";
    private ArrayList<Car> carArrayList = new ArrayList<>();
    private Context context;

    public ViewCarsAdapter(Context context, ArrayList<Car> carArrayList) {
        this.carArrayList = carArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.car_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car car = carArrayList.get(position);

        holder.carNameTextView.setText(car.getBrand() + " " + car.getCarModel());
        holder.carColorTextView.setText(car.getColor());
        holder.carPriceTextView.setText(car.getPricePerHour() + " / " + car.getPricePerDay());

        holder.parentCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return carArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView carImageView;
        TextView carNameTextView;
        TextView carColorTextView;
        TextView carPriceTextView;
        CardView parentCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            carImageView = itemView.findViewById(R.id.image_view_car_image);
            carNameTextView = itemView.findViewById(R.id.text_view_car_name);
            carColorTextView = itemView.findViewById(R.id.text_view_car_color);
            carPriceTextView = itemView.findViewById(R.id.text_view_car_price);
            parentCardView = itemView.findViewById(R.id.card_view_parent);

        }

    }
}
