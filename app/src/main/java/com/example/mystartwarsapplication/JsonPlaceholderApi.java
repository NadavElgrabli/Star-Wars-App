package com.example.mystartwarsapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JsonPlaceholderApi {

    @GET
    Call<StarshipResponse> getStarshipsResponse(@Url String url);

    @GET
    Call<PeopleResponse> getPeopleResponse(@Url String url);

    @GET
    Call<Film> getFilmByUrl(@Url String url);

}


//    @GET("starships/")
//    Call<StarshipResponse> getStarshipsResponse();







