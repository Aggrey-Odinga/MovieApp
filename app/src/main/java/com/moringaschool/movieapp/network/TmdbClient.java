package com.moringaschool.movieapp.network;


import android.content.Context;
import android.widget.Toast;

import com.moringaschool.movieapp.Constants;
import com.moringaschool.movieapp.Listner.OnSearchApiListener;

import com.moringaschool.movieapp.Models.TmdbSearchMultiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class TmdbClient {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public TmdbClient(Context context) {
        this.context = context;
    }
//    method for accessing the interface

    public void searchMovies(OnSearchApiListener listener, String query){
        getMovies getMovies = retrofit.create(TmdbClient.getMovies.class);
        Call<TmdbSearchMultiResponse> call = getMovies.getMovies(Constants.API_KEY, query);

        call.enqueue(new Callback<TmdbSearchMultiResponse>() {
            @Override
            public void onResponse(Call<TmdbSearchMultiResponse> call, Response<TmdbSearchMultiResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(context, "failed to return data", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<TmdbSearchMultiResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
//    interface for calling api
    public interface getMovies{
        @GET("search/multi")
        Call<TmdbSearchMultiResponse> getMovies(
                @Query("api_key") String apikey,
                @Query("query") String query
        );
    }
}
