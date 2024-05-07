// FIRST - doesnt take into consideration the next pages, but understandable
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
//import java.util.Arrays;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class StarshipsActivity extends AppCompatActivity {
//    private RecyclerView recyclerViewStarships;
//    private JsonPlaceholderApi jsonPlaceholderApi;
//    private EditText editTextStarshipName;
//    private Button buttonSearchStarshipByName;
//    private Button buttonBackToMain;
//    private Button buttonMostToLeastExpensive;
//    private Button buttonLeastToMostExpensive;
//    private StarshipsAdapter starshipsAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_starships);
//        findViewsById();
//        setOnClickListeners();
//        jsonPlaceholderApi = ApiClient.getClient().create(JsonPlaceholderApi.class);
//        fetchStarships();
//    }
//
//    private void findViewsById() {
//        recyclerViewStarships = findViewById(R.id.recycler_view_starships);
//        editTextStarshipName = findViewById(R.id.edit_text_starship_name);
//        buttonSearchStarshipByName = findViewById(R.id.button_get_starship_by_title);
//        buttonBackToMain = findViewById(R.id.button_back_to_main_menu);
//        buttonMostToLeastExpensive = findViewById(R.id.button_sort_starships_by_credits_from_highest_to_lowest);
//        buttonLeastToMostExpensive = findViewById(R.id.button_sort_starships_by_credits_from_lowest_to_highest);
//    }
//
//    private void setOnClickListeners() {
//        buttonBackToMain.setOnClickListener(v -> {
//            Intent intent = new Intent(StarshipsActivity.this, MainActivity.class);
//            startActivity(intent);
//        });
//
//        buttonSearchStarshipByName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fetchStarships();
//            }
//        });
//    }
//
//    private void fetchStarships() {
//        Call<StarshipResponse> call = jsonPlaceholderApi.getStarships();
//        call.enqueue(new Callback<StarshipResponse>() {
//            @Override
//            public void onResponse(Call<StarshipResponse> call, Response<StarshipResponse> response) {
//                if (!response.isSuccessful()) {
//                    Log.e("StarshipsActivity", "Failed to fetch starshipResponse: " + response.code());
//                    return;
//                }
//
//                StarshipResponse starshipResponse = response.body();
//                if (starshipResponse != null) {
//                    Starship[] starshipsArray = starshipResponse.getResults();
//                    String starshipName = editTextStarshipName.getText().toString();
//
//                    // Filtering starships if starshipName is not empty
//                    if (!starshipName.isEmpty()) {
//                        starshipsArray = Arrays.stream(starshipsArray)
//                                .filter(starship -> starship.getName().toLowerCase().contains(starshipName.toLowerCase()))
//                                .toArray(Starship[]::new);
//                    }
//
//                    // Setting RecyclerView adapter
//                    starshipsAdapter = new StarshipsAdapter(starshipsArray);
//                    recyclerViewStarships.setLayoutManager(new LinearLayoutManager(StarshipsActivity.this));
//                    recyclerViewStarships.setAdapter(starshipsAdapter);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<StarshipResponse> call, Throwable t) {
//                Log.e("StarshipsActivity", "Failed to fetch starships: " + t.getMessage());
//                Toast.makeText(StarshipsActivity.this, "Couldn't get the information", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//}



// Doesnt display all starships at the beginning. Only after searching for a specific starship
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
//public class StarshipsActivity extends AppCompatActivity {
//    private RecyclerView recyclerViewStarships;
//    private JsonPlaceholderApi jsonPlaceholderApi;
//    private EditText editTextStarshipName;
//    private Button buttonSearchStarshipByName;
//    private Button buttonBackToMain;
//    private Button buttonMostToLeastExpensive;
//    private Button buttonLeastToMostExpensive;
//    private StarshipsAdapter starshipsAdapter;
//    private List<Starship> allStarships;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_starships);
//        findViewsById();
//        setOnClickListeners();
//        jsonPlaceholderApi = ApiClient.getClient().create(JsonPlaceholderApi.class);
//        fetchAllStarships();
//    }
//
//    private void findViewsById() {
//        recyclerViewStarships = findViewById(R.id.recycler_view_starships);
//        editTextStarshipName = findViewById(R.id.edit_text_starship_name);
//        buttonSearchStarshipByName = findViewById(R.id.button_get_starship_by_title);
//        buttonBackToMain = findViewById(R.id.button_back_to_main_menu);
//        buttonMostToLeastExpensive = findViewById(R.id.button_sort_starships_by_credits_from_highest_to_lowest);
//        buttonLeastToMostExpensive = findViewById(R.id.button_sort_starships_by_credits_from_lowest_to_highest);
//    }
//
//    private void setOnClickListeners() {
//        buttonBackToMain.setOnClickListener(v -> {
//            Intent intent = new Intent(StarshipsActivity.this, MainActivity.class);
//            startActivity(intent);
//        });
//
//        buttonSearchStarshipByName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                searchStarships();
//            }
//        });
//    }
//
//    private void fetchAllStarships() {
//        allStarships = new ArrayList<>();
//        fetchStarships();
//    }
//
//    private void fetchStarships() {
//        Call<StarshipResponse> call = jsonPlaceholderApi.getStarships();
//        call.enqueue(new Callback<StarshipResponse>() {
//            @Override
//            public void onResponse(Call<StarshipResponse> call, Response<StarshipResponse> response) {
//                if (!response.isSuccessful()) {
//                    Log.e("StarshipsActivity", "Failed to fetch starships: " + response.code());
//                    return;
//                }
//
//                //Get the Response object
//                StarshipResponse starshipResponse = response.body();
//                if (starshipResponse != null) {
//
//                    // Get the array of Starship objects
//                    Starship[] starshipsArray = starshipResponse.getResults();
//                    allStarships.addAll(Arrays.asList(starshipsArray));
//                    String nextPageUrl = starshipResponse.getNext();
//
//                    // If there is a next page, fetch it recursively
//                    if (nextPageUrl != null && !nextPageUrl.isEmpty()) {
//                        fetchStarships();
//                    } else {
//                        // If there are no more next pages, set RecyclerView adapter
//                        setRecyclerViewAdapter(allStarships);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<StarshipResponse> call, Throwable t) {
//                Log.e("StarshipsActivity", "Failed to fetch starships: " + t.getMessage());
//                Toast.makeText(StarshipsActivity.this, "Couldn't get the information", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//    private void searchStarships() {
//        String query = editTextStarshipName.getText().toString().trim();
//        if (query.isEmpty()) {
//            // If the search query is empty, display all starships
//            setRecyclerViewAdapter(allStarships);
//        } else {
//            List<Starship> searchResult = new ArrayList<>();
//            for (Starship starship : allStarships) {
//                if (starship.getName().toLowerCase().contains(query.toLowerCase())) {
//                    searchResult.add(starship);
//                }
//            }
//            setRecyclerViewAdapter(searchResult);
//        }
//    }
//
//    private void setRecyclerViewAdapter(List<Starship> starshipsList) {
//        // Convert the list to an array
//        Starship[] starshipsArray = starshipsList.toArray(new Starship[0]);
//
//        // Create the adapter with the array
//        starshipsAdapter = new StarshipsAdapter(starshipsArray);
//
//        // Set the adapter to the RecyclerView
//        recyclerViewStarships.setLayoutManager(new LinearLayoutManager(this));
//        recyclerViewStarships.setAdapter(starshipsAdapter);
//    }
//}




/////////////////////////////////// 3rd VERSION, WORKS PERFECT DONT UNDERSTAND
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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarshipsActivity extends AppCompatActivity {
    private RecyclerView recyclerViewStarships;
    private JsonPlaceholderApi jsonPlaceholderApi;
    private EditText editTextStarshipName;
    private Button buttonSearchStarshipByName;
    private Button buttonBackToMain;
    private Button buttonMostToLeastExpensive;
    private Button buttonLeastToMostExpensive;
    private StarshipsAdapter starshipsAdapter;
    private List<Starship> allStarships;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starships);
        findViewsById();
        setOnClickListeners();
        jsonPlaceholderApi = ApiClient.getClient().create(JsonPlaceholderApi.class);
        fetchAllStarships();
    }

    private void findViewsById() {
        recyclerViewStarships = findViewById(R.id.recycler_view_starships);
        editTextStarshipName = findViewById(R.id.edit_text_starship_name);
        buttonSearchStarshipByName = findViewById(R.id.button_get_starship_by_title);
        buttonBackToMain = findViewById(R.id.button_back_to_main_menu);
        buttonMostToLeastExpensive = findViewById(R.id.button_sort_starships_by_credits_from_highest_to_lowest);
        buttonLeastToMostExpensive = findViewById(R.id.button_sort_starships_by_credits_from_lowest_to_highest);
    }

    private void setOnClickListeners() {
        buttonBackToMain.setOnClickListener(v -> {
            Intent intent = new Intent(StarshipsActivity.this, MainActivity.class);
            startActivity(intent);
        });

        buttonSearchStarshipByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchStarships();
            }
        });

        // Sort starships from most to least expensive
        buttonMostToLeastExpensive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortStarshipsByPrice(true);
            }
        });

        // Sort starships from least to most expensive
        buttonLeastToMostExpensive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortStarshipsByPrice(false);
            }
        });
    }

    private void fetchAllStarships() {
        allStarships = new ArrayList<>();
        fetchStarships("https://swapi.py4e.com/api/starships/");
    }

    private void fetchStarships(String url) {
        Call<StarshipResponse> call = jsonPlaceholderApi.getStarshipsResponse(url);
        call.enqueue(new Callback<StarshipResponse>() {
            @Override
            public void onResponse(Call<StarshipResponse> call, Response<StarshipResponse> response) {
                if (!response.isSuccessful()) {
                    Log.e("StarshipsActivity", "Failed to fetch starships: " + response.code());
                    return;
                }

                StarshipResponse starshipResponse = response.body();
                if (starshipResponse != null) {
                    Starship[] starshipsArray = starshipResponse.getResults();
                    allStarships.addAll(Arrays.asList(starshipsArray));
                    String nextPageUrl = starshipResponse.getNext();

                    // If there is a next page, fetch it recursively
                    if (nextPageUrl != null && !nextPageUrl.isEmpty()) {
                        fetchStarships(nextPageUrl);
                    } else {
                        // If there are no more next pages, set RecyclerView adapter
                        setRecyclerViewAdapter(allStarships);
                    }
                }
            }

            @Override
            public void onFailure(Call<StarshipResponse> call, Throwable t) {
                Log.e("StarshipsActivity", "Failed to fetch starships: " + t.getMessage());
                Toast.makeText(StarshipsActivity.this, "Couldn't get the information", Toast.LENGTH_LONG).show();
            }
        });
    }

//    //find any letter in query
//    private void searchStarships() {
//        String query = editTextStarshipName.getText().toString().trim();
//        if (query.isEmpty()) {
//            // If the search query is empty, display all starships
//            setRecyclerViewAdapter(allStarships);
//        } else {
//            List<Starship> searchResult = new ArrayList<>();
//            for (Starship starship : allStarships) {
//                if (starship.getName().toLowerCase().contains(query.toLowerCase())) {
//                    searchResult.add(starship);
//                }
//            }
//            setRecyclerViewAdapter(searchResult);
//        }
//    }

    private void searchStarships() {
        String query = editTextStarshipName.getText().toString().trim().toLowerCase(); // Convert query to lowercase
        if (query.isEmpty()) {
            // If the search query is empty, display all starships
            setRecyclerViewAdapter(allStarships);
        } else {
            List<Starship> searchResult = new ArrayList<>();
            boolean found = false;
            for (Starship starship : allStarships) {
                if (starship.getName().toLowerCase().equals(query)) { // Compare in lowercase
                    searchResult.add(starship);
                    found = true;
                }
            }
            if (found) {
                setRecyclerViewAdapter(searchResult);
            } else {
                // If no starship matches the query, show a toast message
                Toast.makeText(this, "Starship doesn't exist", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void sortStarshipsByPrice(boolean mostToLeast) {
        // Copy the list to avoid modifying the original list
        List<Starship> sortedStarships = new ArrayList<>(allStarships);

        // Sort the list based on cost_in_credits
        Collections.sort(sortedStarships, new Comparator<Starship>() {
            @Override
            public int compare(Starship s1, Starship s2) {
                // Get the cost in credits for comparison
                String cost1String = s1.getCost_in_credits().replaceAll("[^\\d]", "");
                String cost2String = s2.getCost_in_credits().replaceAll("[^\\d]", "");

                // Check for empty strings
                if (cost1String.isEmpty() && cost2String.isEmpty()) {
                    return 0; // Both are considered equal
                } else if (cost1String.isEmpty()) {
                    return mostToLeast ? 1 : -1; // Empty string is considered greater if sorting from most to least expensive
                } else if (cost2String.isEmpty()) {
                    return mostToLeast ? -1 : 1; // Empty string is considered smaller if sorting from most to least expensive
                }

                // Parse the cost in credits
                long price1 = Long.parseLong(cost1String);
                long price2 = Long.parseLong(cost2String);

                // Compare prices based on sorting order
                return mostToLeast ? Long.compare(price2, price1) : Long.compare(price1, price2);
            }
        });

        // Set the sorted list to the RecyclerView adapter
        setRecyclerViewAdapter(sortedStarships);
    }




    private void setRecyclerViewAdapter(List<Starship> starshipsList) {
        // Convert the list to an array
        Starship[] starshipsArray = starshipsList.toArray(new Starship[0]);

        // Create the adapter with the array
        starshipsAdapter = new StarshipsAdapter(starshipsArray);

        // Set the adapter to the RecyclerView
        recyclerViewStarships.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewStarships.setAdapter(starshipsAdapter);
    }

}





















//// 4th VERSION - understand but doesnt work
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
//public class StarshipsActivity extends AppCompatActivity {
//    private RecyclerView recyclerViewStarships;
//    private JsonPlaceholderApi jsonPlaceholderApi;
//    private EditText editTextStarshipName;
//    private Button buttonSearchStarshipByName;
//    private Button buttonBackToMain;
//    private Button buttonMostToLeastExpensive;
//    private Button buttonLeastToMostExpensive;
//    private StarshipsAdapter starshipsAdapter;
//    private List<Starship> allStarships;
//    private Starship[] filteredStarships;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_starships);
//        findViewsById();
//        setOnClickListeners();
//        jsonPlaceholderApi = ApiClient.getClient().create(JsonPlaceholderApi.class);
//        fetchStarships();
//    }
//
//    private void findViewsById() {
//        recyclerViewStarships = findViewById(R.id.recycler_view_starships);
//        editTextStarshipName = findViewById(R.id.edit_text_starship_name);
//        buttonSearchStarshipByName = findViewById(R.id.button_get_starship_by_title);
//        buttonBackToMain = findViewById(R.id.button_back_to_main_menu);
//        buttonMostToLeastExpensive = findViewById(R.id.button_sort_starships_by_credits_from_highest_to_lowest);
//        buttonLeastToMostExpensive = findViewById(R.id.button_sort_starships_by_credits_from_lowest_to_highest);
//    }
//
//    private void setOnClickListeners() {
//        buttonBackToMain.setOnClickListener(v -> {
//            Intent intent = new Intent(StarshipsActivity.this, MainActivity.class);
//            startActivity(intent);
//        });
//
//        buttonSearchStarshipByName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fetchStarships();
//            }
//        });
//    }
//
//
//    private void fetchStarships() {
//        allStarships = new ArrayList<>();
//        Call<StarshipResponse> call = jsonPlaceholderApi.getStarships();
//        call.enqueue(new Callback<StarshipResponse>() {
//            @Override
//            public void onResponse(Call<StarshipResponse> call, Response<StarshipResponse> response) {
//                if (!response.isSuccessful()) {
//                    //Log error if fetching is not successful
//                    Log.e("StarshipsActivity", "Failed to fetch response: " + response.code());
//                    return;
//                }
//
//                //Get the Response object
//                StarshipResponse starshipResponse = response.body();
//                if (starshipResponse != null) {
//
//                    // Get the array of Starship objects
//                    Starship[] starshipsArray = starshipResponse.getResults();
//
//                    // Add the array to the list of all starships
//                    allStarships.addAll(Arrays.asList(starshipsArray));
//                    String nextPageUrl = starshipResponse.getNext();
//
//                    // If there is a next page, fetch it recursively
//                    if (nextPageUrl != null && !nextPageUrl.isEmpty()) {
//                        fetchStarships();
//                    } else {
//
//                        //convert allStarships from list to array
//                        Starship[] allStarshipsArray = allStarships.toArray(new Starship[0]);
//
//                        //Get entered input from EditText fields
//                        final String enteredStarshipTitle = editTextStarshipName.getText().toString().trim();
//
//                        //Check if entered inputs exist in list of all starships
//                        boolean starShipTitleExists = Arrays.stream(allStarshipsArray).anyMatch(starship -> starship.getName().contains(enteredStarshipTitle));
//
//                        if (!starShipTitleExists && !enteredStarshipTitle.isEmpty()) {
//                            Toast.makeText(StarshipsActivity.this, "Starship doesn't exist", Toast.LENGTH_LONG).show();
//                        }
//
//                        //Check if input is not empty
//                        if (!enteredStarshipTitle.isEmpty()) {
//                            //Filter starships by entered input
//                            filteredStarships = Arrays.stream(allStarshipsArray).filter(starship -> starship.getName().contains(enteredStarshipTitle)).toArray(Starship[]::new);
//                        } else {
//                            //If input is empty, display all starships
//                            filteredStarships = allStarshipsArray;
//                        }
//
//                        //Set up RecyclerView with the filtered starships
//                        starshipsAdapter = new StarshipsAdapter(filteredStarships);
//                        recyclerViewStarships.setLayoutManager(new LinearLayoutManager(StarshipsActivity.this));
//                        recyclerViewStarships.setAdapter(starshipsAdapter);
//
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<StarshipResponse> call, Throwable t) {
//                Log.e("StarshipsActivity", "Failed to fetch starships: " + t.getMessage());
//                Toast.makeText(StarshipsActivity.this, "Couldn't get the information", Toast.LENGTH_LONG).show();
//            }
////        });
//    }
//
//}




