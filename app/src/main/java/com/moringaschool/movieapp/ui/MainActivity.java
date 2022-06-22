package com.moringaschool.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.moringaschool.movieapp.Listner.OnMovieClickListener;
import com.moringaschool.movieapp.Listner.OnSearchApiListener;
import com.moringaschool.movieapp.Models.TmdbSearchMultiResponse;
import com.moringaschool.movieapp.R;
import com.moringaschool.movieapp.adapters.HomeRecyclerAdapter;
import com.moringaschool.movieapp.network.TmdbClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnMovieClickListener {
    SearchView search_view;
    RecyclerView recycler_view_home;
    HomeRecyclerAdapter adapter;
    TmdbClient client;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view = findViewById(R.id.search_view);
        recycler_view_home = findViewById(R.id.recycler_view_home);

        dialog = new ProgressDialog(this);
        client = new TmdbClient(this);


        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Searching.....");
                dialog.show();

                client.searchMovies(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
//    create listener for onsearch api listner
    private final OnSearchApiListener listener = new OnSearchApiListener() {
    @Override
    public void onResponse(TmdbSearchMultiResponse response) {
        dialog.dismiss();
        if(response == null){
            Toast.makeText(MainActivity.this, "No data available", Toast.LENGTH_SHORT).show();
            return;
        }
        ShowResult(response);
    }

    @Override
    public void onError(String message) {
        dialog.dismiss();
        Toast.makeText(MainActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
    }
    };

    private void ShowResult(TmdbSearchMultiResponse response) {
        recycler_view_home.setHasFixedSize(true);
        recycler_view_home.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

//        initialize adapter
        adapter = new HomeRecyclerAdapter(this, response.getResults(), this);
        recycler_view_home.setAdapter(adapter);
    }

    @Override
    public void onMovieClicked(int id) {
        Toast.makeText(MainActivity.this, id, Toast.LENGTH_SHORT).show();
    }
}