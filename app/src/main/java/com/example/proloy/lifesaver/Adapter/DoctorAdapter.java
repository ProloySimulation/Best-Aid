package com.example.proloy.lifesaver.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proloy.lifesaver.Model.Doctor;
import com.example.proloy.lifesaver.R;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Doctor> doctorList;

    //getting the context and product list with constructor
    public DoctorAdapter(Context mCtx, List<Doctor> productList) {
        this.mCtx = mCtx;
        this.doctorList = doctorList;
    }

    @Override
    public DoctorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_doctors, null);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DoctorViewHolder holder, int position) {
        //getting the product of the specified position
        Doctor doctor = doctorList.get(position);

        //binding the data with the viewholder views
        holder.tvTitle.setText(doctor.getName());
        holder.tvDesignation.setText(doctor.getDesignation());
        holder.tvPrice.setText(String.valueOf(doctor.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(doctor.getImage()));

    }


    @Override
    public int getItemCount() {
        return doctorList.size();
    }


    class DoctorViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDesignation, tvPrice;
        ImageView imageView;

        public DoctorViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.textViewTitle);
            tvDesignation = itemView.findViewById(R.id.textViewShortDesc);
            tvPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.ivDoctor);
        }
    }
}
