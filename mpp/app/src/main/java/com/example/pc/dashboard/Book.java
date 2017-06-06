package com.example.pc.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Book extends AppCompatActivity {
    GridView gvn;
    Context context;
    ArrayList prgmName;
    public static String[] booklist = {"Book1", "Book2", "Book3", "Book4","Book1", "Book2", "Book3", "Book4","Book1", "Book2", "Book3", "Book4","Book1", "Book2", "Book3", "Book4"};
    public static int[] booksrc = {R.drawable.images, R.drawable.periodical, R.drawable.mpp, R.drawable.periodicals,R.drawable.images, R.drawable.periodical, R.drawable.mpp, R.drawable.periodicals,R.drawable.images, R.drawable.periodical, R.drawable.mpp, R.drawable.periodicals,R.drawable.images, R.drawable.periodical, R.drawable.mpp, R.drawable.periodicals};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        gvn = (GridView) findViewById(R.id.gridView1);
        gvn.setAdapter(new CustomAdapter(this, booklist, booksrc));

        gvn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> view, View cell, int position, long id) {
                Intent i = new Intent(Book.this,SingleView.class);

                i.setAction(Intent.ACTION_SEND);
                i.putExtra("id1",booklist[position]);

                i.setType("image/*");
                startActivity(i);
            }
        });
    }
}
