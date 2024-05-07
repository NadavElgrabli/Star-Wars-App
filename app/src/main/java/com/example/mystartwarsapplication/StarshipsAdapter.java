package com.example.mystartwarsapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StarshipsAdapter extends RecyclerView.Adapter<StarshipsAdapter.StarshipsViewHolder>{
    private Starship[] starships;


    @Override
    public int getItemCount() {
        return starships.length;
    }

    public StarshipsAdapter(Starship[] starships) {
        this.starships = starships;
    }
    @NonNull
    @Override
    public StarshipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_starship, parent, false);
        return new StarshipsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarshipsViewHolder holder, int position) {
        holder.bind(starships[position]);
    }


    static class StarshipsViewHolder extends RecyclerView.ViewHolder {
        private TextView starshipName;
        private TextView starshipCost;

        public StarshipsViewHolder(View itemView) {
            super(itemView);
            starshipName = itemView.findViewById(R.id.text_view_starship_name);
            starshipCost = itemView.findViewById(R.id.text_view_starship_cost_in_credits);
        }

        public void bind(Starship starship) {
            starshipName.setText("Starship Name: " + starship.getName());
            starshipCost.setText("Starship Cost: " + starship.getCost_in_credits());
        }

    }
}
