package com.example.pc.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Periodicals extends AppCompatActivity {
    GridView gvn1;
    Context context;
    ArrayList prgmName;
    public static String[] booklist = {"Periodical1", "Periodical2", "Periodical3", "Periodical4","Periodical1", "Periodical2", "Periodical3", "Periodical4","Periodical1", "Periodical2", "Periodical3", "Periodical4","Periodical1", "Periodical2", "Periodical3", "Periodical4",};
    public static int[] booksrc = {R.drawable.book1, R.drawable.periodical, R.drawable.book7, R.drawable.periodical,R.drawable.book2, R.drawable.periodical, R.drawable.book7, R.drawable.periodical,R.drawable.book5, R.drawable.periodical, R.drawable.book9, R.drawable.periodical,R.drawable.book3, R.drawable.periodical, R.drawable.book4, R.drawable.periodical};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodicals);
        gvn1 = (GridView) findViewById(R.id.gridView2);
        gvn1.setAdapter(new PeriodicalCustomAdapter(this, booklist, booksrc));

        gvn1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> view, View cell, int position, long id) {
                Intent myIntent = new Intent(Periodicals.this, SingleViewPeriodical.class);
                Bundle bundle = new Bundle();
                bundle.putInt("image", booksrc[position]); //image5 or any image
                myIntent.putExtra("id1",booklist[position]);
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });
    }
}
