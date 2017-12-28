package com.example.aaa.madproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookActivity extends AppCompatActivity {


    UserService userService;
    EditText editname;
    EditText editwriter;
    EditText editprice;
    Button update;
    Button delete;
    Button add;
    TextView price;
    Book book = new Book();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);


        editname = findViewById(R.id.edname);
        editwriter = findViewById(R.id.edwriter);
        editprice = findViewById(R.id.edprice);

        update = findViewById(R.id.button);
        delete = findViewById(R.id.delbtn);
        add = findViewById(R.id.adbtn);
        userService = ApiUrls.getUserService();

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("book_name");
        String writer = extras.getString("book_writer");
        String price = extras.getString("book_price");

        editname.setText(name);
        editwriter.setText(writer);
        editprice.setText(price);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book.setName(editname.getText().toString());
                book.setWriter(editwriter.getText().toString());
                book.setPrice(editprice.getText().toString());
                adduser(book);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book.setName(editname.getText().toString());
                book.setWriter(editwriter.getText().toString());
                book.setPrice(editprice.getText().toString());
                Updateuser(Integer.parseInt(String.valueOf(book.getId())),book);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteuser(book.getId());
            }
        });

    }


    public void adduser(Book b) {
        Call<Book> call = userService.addbook(b);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BookActivity.this, " New User Added Succesfully ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });
    }



    public void Updateuser(int id,Book b) {
        Call<Book> call = userService.updatebook(id,b);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BookActivity.this, " New User Added Succesfully ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });
    }
    public void deleteuser(int id) {
        Call<Book> call = userService.deleteuser(id);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BookActivity.this, " New User Added Succesfully ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });
    }
}

