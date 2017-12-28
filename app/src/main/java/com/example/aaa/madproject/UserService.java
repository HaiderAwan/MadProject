package com.example.aaa.madproject;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by aaa on 12/27/2017.
 */

public interface UserService {


    @GET("book")
Call<List<Book>> getbook();

    @POST("book")
Call<Book> addbook(@Body Book book);

    @PUT(" book/[id]")
    Call<Book> updatebook(@Path ("id")int id,@Body Book book);

    @DELETE("book/[id]")
    Call<Book> deleteuser (@Path("id")int id);

}
