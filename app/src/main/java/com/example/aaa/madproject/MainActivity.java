package com.example.aaa.madproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String TAG ="MTAG";
    Button btnaddbook;
    Button btngetbooklist;
    ListView listView;

    UserService userService;
    List<Book> list = new ArrayList<Book>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnaddbook = findViewById(R.id.addbook);
        btngetbooklist = findViewById(R.id.getbooklist);
        listView = findViewById(R.id.listview);
        userService = ApiUrls.getUserService();

        btngetbooklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // i will get list here
            }
        });
    }







    public void getUserList()
    {
        Call<List<Book>> call = userService.getbook();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if(response.isSuccessful()){
                    list =  response.body();
                    listView.setAdapter(new MyBookAdapter(MainActivity.this,R.layout.list_book,list));
                }
            }


            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.e("onFailure: ",  t.getMessage() );
            }
        });
    }
}
