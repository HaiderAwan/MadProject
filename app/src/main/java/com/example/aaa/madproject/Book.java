package com.example.aaa.madproject;

import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aaa on 12/27/2017.
 */

public class Book {
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("name")
    @Expose
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("Writer")
    @Expose
    String writer;
    @SerializedName("price")
    @Expose
    String price;

    public Book() {
    }

    public Book(String name, String writer, String price) {
        this.name = name;
        this.writer = writer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
