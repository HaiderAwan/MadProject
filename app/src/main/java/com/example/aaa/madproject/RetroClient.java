package com.example.aaa.madproject;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aaa on 12/27/2017.
 */

public class RetroClient {

    private static Retrofit retrofit = null;

        public static Retrofit  getclient(String url){
            if(retrofit == null){
                retrofit = new Retrofit.Builder().baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }

}
