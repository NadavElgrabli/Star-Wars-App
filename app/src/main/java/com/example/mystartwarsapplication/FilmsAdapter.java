//package com.example.mystartwarsapplication;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {
//
//    private Film[] films;
//
//    public FilmsAdapter(Film[] films) {
//        this.films = films;
//    }
//
//    @Override
//    public int getItemCount() {
//        return films.length;
//    }
//
//    @NonNull
//    @Override
//    public FilmsAdapter.FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
//        return new FilmsViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull FilmsAdapter.FilmsViewHolder holder, int position) {
//        holder.bind(films[position]);
//    }
//
//
//    static class FilmsViewHolder extends RecyclerView.ViewHolder {
//        private TextView filmTitle;
//
//        public FilmsViewHolder(@NonNull View itemView) {
//            super(itemView);
//            filmTitle = itemView.findViewById(R.id.text_view_film_title);
//        }
//
//        public void bind(Film film) {
//            filmTitle.setText("Film Title: " + film.getTitle());
//        }
//    }
//}
//
//
//
//





package com.example.mystartwarsapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {

    private List<String> filmTitles; // Change the data type to List<String>

    public FilmsAdapter(List<String> filmTitles) { // Update constructor parameter type
        this.filmTitles = filmTitles;
    }

    @Override
    public int getItemCount() {
        return filmTitles.size(); // Use size() method for List
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new FilmsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.bind(filmTitles.get(position)); // Use get() method for List
    }

    static class FilmsViewHolder extends RecyclerView.ViewHolder {
        private TextView filmTitle;

        public FilmsViewHolder(@NonNull View itemView) {
            super(itemView);
            filmTitle = itemView.findViewById(R.id.text_view_film_title);
        }

        public void bind(String filmTitle) { // Update parameter type
            this.filmTitle.setText("Film Title: " + filmTitle);
        }
    }
}
