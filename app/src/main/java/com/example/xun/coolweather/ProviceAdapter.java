package com.example.xun.coolweather;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Xun on 2017/5/5.
 */

public class ProviceAdapter extends ArrayAdapter<Provice> {
    private int resourceId;
    public ProviceAdapter(Context context, int textViewResourceId, List<Provice> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Provice provice=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView proviceName= (TextView) view.findViewById(R.id.provice_name);
        proviceName.setText(provice.getName());
        return view;
    }
}
