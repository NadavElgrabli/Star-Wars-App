//package com.example.mystartwarsapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class PeopleActivity extends AppCompatActivity {
//    private RecyclerView recyclerViewPeople;
//    private JsonPlaceholderApi jsonPlaceholderApi;
//    private EditText editTextPeopleName;
//    private Button buttonSearchPeopleByName;
//    private Button buttonBackToMain;
//    private PeopleAdapter peopleAdapter;
//    private List<People> allPeople;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_people);
//        findViewsById();
//        setOnClickListeners();
//        jsonPlaceholderApi = ApiClient.getClient().create(JsonPlaceholderApi.class);
//        fetchAllPeople();
//    }
//
//    public void findViewsById() {
//        // Find views by their IDs
//        recyclerViewPeople = findViewById(R.id.recycler_view_people);
//        editTextPeopleName = findViewById(R.id.edit_text_people_name);
//        buttonSearchPeopleByName = findViewById(R.id.button_search_people_by_name);
//        buttonBackToMain = findViewById(R.id.button_back_to_main_menu);
//    }
//
//    public void setOnClickListeners() {
//        // Set onClickListeners for buttons
//        buttonBackToMain.setOnClickListener(v -> {
//            Intent intent = new Intent(PeopleActivity.this, MainActivity.class);
//            startActivity(intent);
//        });
//
//        buttonSearchPeopleByName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                searchPeople();
//            }
//        });
//
//        // Update RecyclerView when any of the filter fields is cleared
//        editTextPeopleName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus && editTextPeopleName.getText().toString().isEmpty()) {
//                    fetchAllPeople();
//                }
//            }
//        });
//    }
//
//    private void fetchAllPeople() {
//        allPeople = new ArrayList<>();
//        fetchPeople("https://swapi.py4e.com/api/people/");
//    }
//
//    public void fetchPeople(String url) {
//        Call<PeopleResponse> call = jsonPlaceholderApi.getPeopleResponse(url);
//        call.enqueue(new Callback<PeopleResponse>() {
//            @Override
//            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
//                if (!response.isSuccessful()) {
//                    Log.e("PeopleActivity", "Failed to fetch people: " + response.code());
//                    Toast.makeText(PeopleActivity.this, "Failed to fetch people: " + response.code(), Toast.LENGTH_LONG).show();
//                    return;
//                }
//                PeopleResponse peopleResponse = response.body();
//                if (peopleResponse != null) {
//                    People[] peopleArray = peopleResponse.getResults();
//                    allPeople.addAll(Arrays.asList(peopleArray));
//                    String nextPageUrl = peopleResponse.getNext();
//
//                    // If there is a next page, fetch it recursively
//                    if (nextPageUrl != null && !nextPageUrl.isEmpty()) {
//                        fetchPeople(nextPageUrl);
//                    } else {
//                        // If there are no more next pages, set RecyclerView adapter
//                        setRecyclerViewAdapter(allPeople);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PeopleResponse> call, Throwable t) {
//                Log.e("PeopleActivity", "Failed to fetch people: " + t.getMessage());
//                Toast.makeText(PeopleActivity.this, "Couldn't get the information", Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }
//
//
//    private void searchPeople() {
//        String query = editTextPeopleName.getText().toString().trim().toLowerCase(); // Convert query to lowercase
//        if (query.isEmpty()) {
//            // If the search query is empty, display all people
//            setRecyclerViewAdapter(allPeople);
//        } else {
//            List<People> searchResult = new ArrayList<>();
//            boolean found = false;
//            for (People people : allPeople) {
//                if (people.getName().toLowerCase().equals(query)) { // Compare in lowercase
//                    searchResult.add(people);
//                    found = true;
//                }
//            }
//            if (found) {
//                setRecyclerViewAdapter(searchResult);
//            } else {
//                // If no person matches the query, show a toast message
//                Toast.makeText(this, "Person doesn't exist", Toast.LENGTH_LONG).show();
//            }
//        }
//    }
//
//
//
//
//    private void setRecyclerViewAdapter(List<People> peopleList) {
//        // Convert the list to an array
//        People[] peopleArray = peopleList.toArray(new People[0]);
//
//        // Create the adapter with the array
//        peopleAdapter = new PeopleAdapter(peopleArray);
//
//        // Set the adapter to the RecyclerView
//        recyclerViewPeople.setLayoutManager(new LinearLayoutManager(this));
//        recyclerViewPeople.setAdapter(peopleAdapter);
//    }
//
//
//}



package com.example.mystartwarsapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleActivity extends AppCompatActivity {
    private RecyclerView recyclerViewPeople;
    private JsonPlaceholderApi jsonPlaceholderApi;
    private EditText editTextPeopleName;
    private Button buttonSearchPeopleByName;
    private Button buttonBackToMain;
    private PeopleAdapter peopleAdapter;
    private List<People> allPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        findViewsById();
        setOnClickListeners();
        jsonPlaceholderApi = ApiClient.getClient().create(JsonPlaceholderApi.class);
        fetchAllPeople();
    }

    // Method to find views by their IDs
    private void findViewsById() {
        recyclerViewPeople = findViewById(R.id.recycler_view_people);
        editTextPeopleName = findViewById(R.id.edit_text_people_name);
        buttonSearchPeopleByName = findViewById(R.id.button_search_people_by_name);
        buttonBackToMain = findViewById(R.id.button_back_to_main_menu);
    }

    // Method to set click listeners for buttons
    private void setOnClickListeners() {
        // Click listener for back button
        buttonBackToMain.setOnClickListener(v -> {
            Intent intent = new Intent(PeopleActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // Click listener for search button
        buttonSearchPeopleByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPeople();
            }
        });

        // Focus change listener for edit text
        editTextPeopleName.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus && editTextPeopleName.getText().toString().isEmpty()) {
                // If edit text loses focus and is empty, fetch all people data
                fetchAllPeople();
            }
        });
    }

    // Method to fetch all people data from API
    private void fetchAllPeople() {
        allPeople = new ArrayList<>();
        fetchPeople("https://swapi.py4e.com/api/people/");
    }

    // Method to fetch people data from API
    private void fetchPeople(String url) {
        Call<PeopleResponse> call = jsonPlaceholderApi.getPeopleResponse(url);
        call.enqueue(new Callback<PeopleResponse>() {
            @Override
            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                if (!response.isSuccessful()) {
                    // If response is not successful, log error and show toast message
                    Log.e("PeopleActivity", "Failed to fetch people: " + response.code());
                    Toast.makeText(PeopleActivity.this, "Failed to fetch people: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                PeopleResponse peopleResponse = response.body();
                if (peopleResponse != null) {
                        // If response is successful, extract people data and check for pagination
                    List<People> peopleList = new ArrayList<>();
                    for (People person : peopleResponse.getResults()) {
                        // Fetch films for each person
                        fetchFilmsForPerson(person);
                        peopleList.add(person);
                    }
                    allPeople.addAll(peopleList);
                    String nextPageUrl = peopleResponse.getNext();

                    // If there is a next page, fetch it recursively
                    if (nextPageUrl != null && !nextPageUrl.isEmpty()) {
                        fetchPeople(nextPageUrl);
                    } else {
                        // If there are no more next pages, set RecyclerView adapter
                        setRecyclerViewAdapter(allPeople);
                    }
                }
            }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                // If request fails, log error and show toast message
                Log.e("PeopleActivity", "Failed to fetch people: " + t.getMessage());
                Toast.makeText(PeopleActivity.this, "Couldn't get the information", Toast.LENGTH_LONG).show();
            }
        });
    }

    // Method to fetch films for a person from API
    private void fetchFilmsForPerson(People person) {
        List<String> filmUrls = person.getFilms();
        List<String> filmTitles = new ArrayList<>();
        for (String url : filmUrls) {
            // Iterate through film URLs and fetch each film data
            Call<Film> call = jsonPlaceholderApi.getFilmByUrl(url);
            call.enqueue(new Callback<Film>() {
                @Override
                public void onResponse(Call<Film> call, Response<Film> response) {
                    if (response.isSuccessful()) {
                        // If response is successful, extract film title and add to list
                        Film film = response.body();
                        if (film != null) {
                            filmTitles.add(film.getTitle());
                            if (filmTitles.size() == filmUrls.size()) {
                                // If all films are fetched, set film titles for the person
                                person.setFilms(filmTitles);
                                // Notify adapter that data has changed
                                if (peopleAdapter != null) {
                                    peopleAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<Film> call, Throwable t) {
                    // If request fails, log error
                    Log.e("PeopleActivity", "Failed to fetch film: " + t.getMessage());
                }
            });
        }
    }

    // Method to search for people by name
    private void searchPeople() {
        String query = editTextPeopleName.getText().toString().trim().toLowerCase();
        if (query.isEmpty()) {
            // If search query is empty, set RecyclerView adapter with all people
            setRecyclerViewAdapter(allPeople);
        } else {
            // If search query is not empty, filter people list by name
            List<People> searchResult = new ArrayList<>();
            for (People person : allPeople) {
                if (person.getName().toLowerCase().equals(query)) {
                    searchResult.add(person);
                }
            }
            if (!searchResult.isEmpty()) { // Check if searchResult is not empty
                // If search result is not empty, set RecyclerView adapter with search results
                setRecyclerViewAdapter(searchResult);
            } else {
                // If search result is empty, show toast message
                Toast.makeText(this, "Person not found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Method to set RecyclerView adapter
    private void setRecyclerViewAdapter(List<People> peopleList) {
        peopleAdapter = new PeopleAdapter(peopleList);
        recyclerViewPeople.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPeople.setAdapter(peopleAdapter);
    }
}











//    private void searchPeople() {
//        String query = editTextPeopleName.getText().toString().trim().toLowerCase(); // Convert query to lowercase
//        if (query.isEmpty()) {
//            // If the search query is empty, display all people
//            setRecyclerViewAdapter(allPeople);
//        } else {
//            List<People> searchResult = new ArrayList<>();
//            boolean found = false;
//            for (People person : allPeople) {
//                if (person.getName().toLowerCase().equals(query)) { // Compare in lowercase
//                    searchResult.add(person);
//                    found = true;
//                }
//            }
//            if (found) {
//                setRecyclerViewAdapter(searchResult);
//            } else {
//                // If no person matches the query, show a toast message
//                Toast.makeText(this, "Person not found", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }



//    private void searchPeople() {
//        String query = editTextPeopleName.getText().toString().trim().toLowerCase();
//        if (query.isEmpty()) {
//            setRecyclerViewAdapter(allPeople);
//        } else {
//            List<People> searchResult = new ArrayList<>();
//            for (People person : allPeople) {
//                if (person.getName().toLowerCase().equals(query)) {
//                    searchResult.add(person);
//                }
//            }
//            if (!searchResult.isEmpty()) { // Check if searchResult is not empty
//                setRecyclerViewAdapter(searchResult);
//            } else {
//                Toast.makeText(this, "Person not found", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }