package com.example.jessi.simpsonsproject.retrofit;

import android.graphics.drawable.Icon;

import com.example.jessi.simpsonsproject.models.RelatedTopics;
import com.example.jessi.simpsonsproject.models.Simpsons;
import com.example.jessi.simpsonsproject.models.pojo.SimpsonsPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    //"http://api.duckduckgo.com/?q=simpsons+characters&format=json";

    @GET("?q=simpsons+characters&format=json")
    Call <Simpsons> getRelatedTopics();


}
