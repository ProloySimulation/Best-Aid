package com.best_aid.proloy.lifesaver.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.best_aid.proloy.lifesaver.Model.Donor;
import com.best_aid.proloy.lifesaver.R;

import java.util.List;

public class BloodDonorAdapter extends RecyclerView.Adapter <BloodDonorAdapter.ViewHolder>{

    private Context context;
    private List<Donor> donorList;

    public BloodDonorAdapter(Context context, List<Donor> donorList) {
        this.context = context;
        this.donorList = donorList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_donor, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Donor donor = donorList.get(position);

        holder.tvName.setText(donor.getName());
        holder.tvBlood.setText(donor.getBlood());
        holder.tvPhone.setText(donor.getMobile());
    }

    @Override
    public int getItemCount() {
        return donorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvBlood , tvPhone;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvBlood = itemView.findViewById(R.id.tvBlood);
            tvPhone = itemView.findViewById(R.id.tvMobile);
        }
    }
}