//package com.example.mystartwarsapplication;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {
//
//    private People[] people;
//
//    public PeopleAdapter(People[] people) {
//        this.people = people;
//    }
//
//    @Override
//    public int getItemCount() {
//        return people.length;
//    }
//
//
//    @NonNull
//    @Override
//    public PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people, parent, false);
//        return new PeopleViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PeopleViewHolder holder, int position) {
//        holder.bind(people[position]);
//    }
//
//
//    static class PeopleViewHolder extends RecyclerView.ViewHolder {
//        private TextView peopleName;
//        private TextView peopleHeight;
//        private TextView peopleGender;
//        private RecyclerView peopleFilms;
//
//        public PeopleViewHolder(View itemView) {
//            super(itemView);
//            peopleName = itemView.findViewById(R.id.text_view_people_name);
//            peopleHeight = itemView.findViewById(R.id.text_view_people_height);
//            peopleGender = itemView.findViewById(R.id.text_view_people_gender);
//            peopleFilms = itemView.findViewById(R.id.recycler_view_people_films);
//        }
//
//        public void bind(People people) {
//            peopleName.setText("Name: " + people.getName());
//            peopleHeight.setText("Height: " + people.getHeight());
//            peopleGender.setText("Gender: " + people.getGender());
//            //film titles of the person, i dont know how to do this
//
//        }
//    }
//}


package com.example.mystartwarsapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {

    private List<People> peopleList; // Change the data type to List<People>

    public PeopleAdapter(List<People> peopleList) { // Update constructor parameter type
        this.peopleList = peopleList;
    }

    @Override
    public int getItemCount() {
        return peopleList.size(); // Use size() method for List
    }

    @NonNull
    @Override
    public PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people, parent, false);
        return new PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleViewHolder holder, int position) {
        holder.bind(peopleList.get(position)); // Use get() method for List
    }

    static class PeopleViewHolder extends RecyclerView.ViewHolder {
        private TextView peopleName;
        private TextView peopleHeight;
        private TextView peopleGender;
        private RecyclerView recyclerViewFilms;

        public PeopleViewHolder(View itemView) {
            super(itemView);
            peopleName = itemView.findViewById(R.id.text_view_people_name);
            peopleHeight = itemView.findViewById(R.id.text_view_people_height);
            peopleGender = itemView.findViewById(R.id.text_view_people_gender);
            recyclerViewFilms = itemView.findViewById(R.id.recycler_view_people_films);
        }

        public void bind(People person) {
            peopleName.setText("Name: " + person.getName());
            peopleHeight.setText("Height: " + person.getHeight());
            peopleGender.setText("Gender: " + person.getGender());

            // Set up RecyclerView for films
            FilmsAdapter adapter = new FilmsAdapter(person.getFilms());
            recyclerViewFilms.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            recyclerViewFilms.setAdapter(adapter);
        }
    }
}
