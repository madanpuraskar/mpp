package com.example.pc.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pc on 6/1/2017.
 */
public class SingleView extends AppCompatActivity{
TextView t;
    ImageView j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_book);
       Intent i = getIntent();
        j = (ImageView)findViewById(R.id.imgview);
        t = (TextView) findViewById(R.id.tv1);
        t.setText(i.getStringExtra("id1"));
       /* j = (ImageView)findViewById(R.id.imgview);
     // int image= i.getIntExtra("id2",0);
     //   j.setImageResource(image);
        if(getIntent().hasExtra("byteArray")) {

            Bitmap _bitmap = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"),0,getIntent().getByteArrayExtra("byteArray").length);
            j.setImageBitmap(_bitmap);
        }
*/
        Bundle bundle = this.getIntent().getExtras();
        int pic = bundle.getInt("image");
        j.setImageResource(pic);
    }


}
