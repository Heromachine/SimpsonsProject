package com.example.jessi.simpsonsproject.retrofit;

import android.graphics.drawable.Icon;

import com.example.jessi.simpsonsproject.BuildConfig;
import com.example.jessi.simpsonsproject.models.RelatedTopics;
import com.example.jessi.simpsonsproject.models.Simpsons;
import com.example.jessi.simpsonsproject.utils.AppController;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    //"http://api.duckduckgo.com/?q=simpsons+characters&format=json";
    // http://api.duckduckgo.com/?q=the+wire+characters&format=json
    //@GET("?q=simpsons+characters&format=json")
//    @GET("?")
////    Call <Simpsons> getRelatedTopics();


    @GET(BuildConfig.SERVER_URL_XFIN)
    Call <Simpsons> getRelatedTopics();

//    @GET("?q=simpsons+characters&format=json")
//    Call <Simpsons> getRelatedTopics(@Query("q") String data, @Query("format") String format);

}
