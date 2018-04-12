package com.baitap.sin.quanli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class custom_spinnerphannhom_them_gd extends ArrayAdapter<Tenkhoanthuchi> {

    public custom_spinnerphannhom_them_gd(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public custom_spinnerphannhom_them_gd(Context context, int resource, List<Tenkhoanthuchi> items) {
        super(context, resource, items);


    }

    @Override
    public View getView(int postion , View view , ViewGroup parent){
        View v = view ;
        if (v==null){
            LayoutInflater vi ;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.spinner_item,null);

        }
        Tenkhoanthuchi item = getItem(postion);
        if (item != null){
            // ánh xạ + giá trị
            TextView tvspin = (TextView) v.findViewById(R.id.textView6);
            tvspin.setText(item.getTenkhoanthuchi());
}
    return v ;
    } }