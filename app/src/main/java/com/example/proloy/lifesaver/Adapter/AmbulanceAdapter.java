package com.example.proloy.lifesaver.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proloy.lifesaver.Model.Ambulance;
import com.example.proloy.lifesaver.R;

import java.util.List;

public class AmbulanceAdapter extends RecyclerView.Adapter<AmbulanceAdapter.ViewHolder> {

    private Context context ;
    private List<Ambulance> ambulanceList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_donor, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AmbulanceAdapter.ViewHolder holder, int position) {
        Ambulance ambulance = ambulanceList.get(position);

        holder.tvName.setText(ambulance.getDriverName());
        holder.tvBlood.setText(ambulance.getMobile());
    }

    @Override
    public int getItemCount() {
        return ambulanceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvBlood;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvBlood = itemView.findViewById(R.id.tvBlood);
        }
    }
}
