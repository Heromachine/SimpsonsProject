package com.example.jessi.simpsonsproject.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    static Retrofit retrofit;

    //final static String BASE_URL = "http://api.duckduckgo.com/?q=simpsons+characters&format=json";
    final static String BASE_URL = "http://api.duckduckgo.com/";
    public static Retrofit getRetrofitInstance(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if(retrofit == null){


            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            return retrofit;
        }
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
