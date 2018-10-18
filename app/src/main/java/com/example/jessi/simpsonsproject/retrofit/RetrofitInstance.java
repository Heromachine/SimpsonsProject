package com.example.jessi.simpsonsproject.retrofit;

import com.example.jessi.simpsonsproject.BuildConfig;
import com.example.jessi.simpsonsproject.utils.AppController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://api.duckduckgo.com/";
    //private static final String BASE_URL = AppController.getInstance().getURL();

    public static Retrofit getRetrofitInstance() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

}
