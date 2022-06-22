package com.moringaschool.movieapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdbApi {
    @GET("search/multi")
    Call<TmdbSearchMultiResponse> getMovies(
            @Query("apikey") String apikey,
            @Query("query") String query
    );
}
