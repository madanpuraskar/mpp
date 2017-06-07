package com.example.pc.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rs on 6/6/2017.
 */

public class SingleViewPeriodical extends AppCompatActivity {
    TextView t;
    ImageView j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_periodical);
        Intent i = getIntent();
        j = (ImageView) findViewById(R.id.imgview1);
        t = (TextView) findViewById(R.id.tv2);
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