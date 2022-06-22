package com.moringaschool.movieapp.Models;

import com.moringaschool.movieapp.Models.TmdbSearchMultiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdbApi {
    @GET("search/multi")
    Call<TmdbSearchMultiResponse> getMovies(
            @Query("api_key") String apikey,
            @Query("query") String query
    );
}
// /trending/{media_type}/{time_window}
//@GET("/trending/all/week")