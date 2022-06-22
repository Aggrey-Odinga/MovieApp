package com.moringaschool.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    SearchView search_view;
    RecyclerView recycler_view_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        search_view = findViewById(R.id.search_view);
        recycler_view_home = findViewById(R.id.recycler_view_home);
//        String query =
//
//        TmdbApi client = TmdbClient.getClient();
//
//        Call<TmdbSearchMultiResponse> call = client.getMovies(Constants.API_KEY, query);
//
//        call.enqueue(new Callback<TmdbSearchMultiResponse>() {
//            @Override
//            public void onResponse(Call<TmdbSearchMultiResponse> call, Response<TmdbSearchMultiResponse> response) {
//
//                hideProgressBar();
//                if(response.isSuccessful()){
//                    List<Track> tracks = response.body().getMessage().getBody().getTrackList();
//                    Log.d(TAG, String.format("Track Size %d", tracks.size()));
//                    mAdapter = new TrackListAdapter(ArtistsListActivity.this, tracks);
//                    mRecyclerView.setAdapter(mAdapter);
//                    RecyclerView.LayoutManager layoutManager =
//                            new LinearLayoutManager(ArtistsListActivity.this);
//                    mRecyclerView.setLayoutManager(layoutManager);
//                    mRecyclerView.setHasFixedSize(true);
//
//                }
//                else{
//                    showFailureMessage();
//                }
//            }});
    }
}