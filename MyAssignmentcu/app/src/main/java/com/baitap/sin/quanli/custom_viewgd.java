package com.baitap.sin.quanli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class custom_viewgd extends ArrayAdapter<viewds_class> {

    public custom_viewgd(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public custom_viewgd(Context context, int resource, List<viewds_class> items) {
        super(context, resource, items);


    }

    @Override
    public View getView(int postion , View view , ViewGroup parent){
        View v = view ;
        if (v==null){
            LayoutInflater vi ;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.custom_viewgd,null);

        }
        viewds_class b = getItem(postion);
        if (b != null){
            // ánh xạ + giá trị
            ImageView ima = (ImageView) v.findViewById(R.id.imageView2);
            TextView txtngay = (TextView) v.findViewById(R.id.textView4);
                txtngay.setText(b.getNgay());

            TextView tvtloaithuchi = (TextView) v.findViewById(R.id.textView5);
                tvtloaithuchi.setText(b.phannhom);

            TextView tvttaikhoan = (TextView) v.findViewById(R.id.textView3);
                tvttaikhoan.setText(b.taikhoan);
            TextView txttien = (TextView) v.findViewById(R.id.textView2);
                    txttien.setText(String.valueOf(b.sotien));




        }
        return v ;
    }
}
