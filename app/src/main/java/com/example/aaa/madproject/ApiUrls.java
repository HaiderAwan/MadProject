package com.example.aaa.madproject;

import retrofit2.Retrofit;

/**
 * Created by aaa on 12/27/2017.
 */

public class ApiUrls {


    private ApiUrls(){
    }

    public static  final String API_URL= "http://192.168.15.183/apibook/public/api/";

    public static UserService getUserService ()
    {
        return RetroClient.getclient(API_URL).create(UserService.class);
    }

}
