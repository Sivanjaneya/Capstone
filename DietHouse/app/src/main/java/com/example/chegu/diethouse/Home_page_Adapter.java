package com.example.chegu.diethouse;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chegu on 15/10/16.
 */
public class Home_page_Adapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Home_page_Model> data;
    private final LayoutInflater layoutInflater;

    public Home_page_Adapter(Context context,ArrayList ad) {
        this.mContext = context;
        this.data = ad;
        this.layoutInflater =((Activity) context).getLayoutInflater();
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder view = null;
        if (convertView == null){
            view = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.home_page_items, null);
            view.main2activity_image = (ImageView)convertView.findViewById(R.id.gridimage);
            view.main2activity_title = (TextView)convertView.findViewById(R.id.vi2);
            view.message = (TextView)convertView.findViewById(R.id.message);
            convertView.setTag(view);
        }else {
            view = (ViewHolder) convertView.getTag();

        }
        view.main2activity_title.setText(data.get(position).getTitle().toString());
        view.main2activity_image.setImageResource(data.get(position).getImageId());
        view.message.setText(data.get(position).getMessage().toString());
        return convertView;

    }
    private class ViewHolder {
        public ImageView main2activity_image;
        public TextView main2activity_title,message;
    }

}
