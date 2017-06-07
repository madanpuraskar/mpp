package com.example.pc.dashboard;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
public class Dashboard extends AppCompatActivity {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String [] prgmNameList={"Books","Periodicals","About us","PlanVisit"};
    public static int [] prgmImages={R.drawable.images,R.drawable.periodical,R.drawable.mpp,R.drawable.periodicals};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> view, View cell, int position, long id)
            {
                if (position==0)
                 //do whatever you want
                {

                    view.setBackgroundColor(0x00FFFFFF75);
                    Intent intent = new Intent(Dashboard.this, Book.class);

                    startActivity(intent);
                }
              else  if (position==1) {
                    Intent intent = new Intent(Dashboard.this, Periodicals.class);

               startActivity(intent);
                } else  if (position==2) {
                    Intent intent = new Intent(Dashboard.this, Aboutus.class);

               startActivity(intent);
                } else  if (position==3) {
                    Intent intent = new Intent(Dashboard.this, PlanVisit.class);

               startActivity(intent);
                }
            }
        });

//        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int i, long id) {
//
//                Intent intent = new Intent(Dashboard.this,Book .class);
//                startActivity(intent);
//            }
//        });

        // Instance of ImageAdapter Class
       /* gv.setAdapter(new ImageAdpater(this,prgmNameList,prgmImages));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), Look.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void book(View view) {
        Intent i = new Intent(this,Book.class);

        startActivity(i);

    }
}

