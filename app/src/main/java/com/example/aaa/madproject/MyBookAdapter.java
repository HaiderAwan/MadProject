package com.example.aaa.madproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aaa on 12/27/2017.
 */

public class MyBookAdapter extends ArrayAdapter<Book> {

    private Context context;
    private List<Book> books;
    public MyBookAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.books = objects;
    }
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
//   }

    public View getView(final int pos, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_book, parent, false);

        TextView txtbookname = rowView.findViewById(R.id.bookname);
        TextView txtbookwriter = rowView.findViewById(R.id.writername);
        TextView txtbookprice = rowView.findViewById(R.id.price);

        txtbookname.setText(String.format("Book_Name :  ", books.get(pos).getName()));
        txtbookwriter.setText(String.format("Writer_Name:  ", books.get(pos).getWriter()));
        txtbookprice.setText(String.format("Price :  ", books.get(pos).getPrice()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,BookActivity.class);
                intent.putExtra("book_name",books.get(pos).getName());
                intent.putExtra("book_writer",books.get(pos).getWriter());
                intent.putExtra("book_price",String.valueOf(books.get(pos).getPrice()));
                context.startActivity(intent);
            }
        });

        return rowView;

    }
}
