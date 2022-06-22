package com.moringaschool.movieapp.Listner;

import com.moringaschool.movieapp.Models.Result;
import com.moringaschool.movieapp.Models.TmdbSearchMultiResponse;


public interface OnSearchApiListener {
    void onResponse(TmdbSearchMultiResponse response);
    void onError(String message);
}
