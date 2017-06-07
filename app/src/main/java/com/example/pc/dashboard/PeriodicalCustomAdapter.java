package com.example.pc.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PeriodicalCustomAdapter extends BaseAdapter{
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;

    public PeriodicalCustomAdapter(Context c,String[] web,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid = null;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //   parent.getChildAt(0).setBackgroundColor(Color.parseColor("@color/colorAccent"));

        if (convertView == null) {

            grid = inflater.inflate(R.layout.periodicals_list, null);
            TextView textView = (TextView) grid.findViewById(R.id.textView3);
            ImageView imageView = (ImageView)grid.findViewById(R.id.imageView3);
            textView.setText(web[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = convertView;
        }
      /*  int color = 0x00FFFFFF; // Transparent
        if (position==0) {
            color = 0xFF0000FF; // Opaque Blue
        }

        grid.setBackgroundColor(color);*/

        return grid;
    }
}