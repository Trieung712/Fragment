package com.test.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListView extends BaseAdapter {
    Context context;
    private ArrayList<SanPham> sanPhams;
    private LayoutInflater inflater;

    public AdapterListView(Context context, ArrayList<SanPham> sanPhams) {
        this.context = context;
        this.sanPhams = sanPhams;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return sanPhams.size();
    }

    @Override
    public Object getItem(int position) {
        return sanPhams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_listview,null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.textViewName = (TextView) convertView.findViewById(R.id.textViewName);
            viewHolder.textViewPrice = (TextView) convertView.findViewById(R.id.textViewPrice);

            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setBackgroundResource(sanPhams.get(position).getImage());
        viewHolder.textViewName.setText(sanPhams.get(position).getName());
        viewHolder.textViewPrice.setText(sanPhams.get(position).getPrice());

        return convertView;
    }
    private class ViewHolder{
        private ImageView imageView;
        private TextView textViewName;
        private TextView textViewPrice;
    }
}
