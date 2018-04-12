package com.baitap.sin.quanli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class list_adapter_caidat extends ArrayAdapter<Tenkhoanthuchi> {

    public list_adapter_caidat(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public list_adapter_caidat(Context context, int resource, List<Tenkhoanthuchi> items) {
        super(context, resource, items);


    }


    @Override
    public View getView(int postion , View view , ViewGroup parent){
         View v = view ;
         if (v==null){
             LayoutInflater vi ;
             vi = LayoutInflater.from(getContext());
             v = vi.inflate(R.layout.custom_list_caidat,null);

         }
         Tenkhoanthuchi item = getItem(postion);
        if (item != null){
         // ánh xạ + giá trị
            ImageView img = (ImageView) v.findViewById(R.id.imgview_caidat_custom);
         TextView tvcdbig = (TextView) v.findViewById(R.id.tvbig_custom_caidat);
            tvcdbig.setText(item.getTenkhoanthuchi());
         TextView tvcdsmall = (TextView) v.findViewById(R.id.tvsmall_custom_caidat);
            if(item.getIddngoaithuchi()==1){
                tvcdsmall.setText("Khoản thu");
            }
            if(item.getIddngoaithuchi()==2) tvcdsmall.setText("Khoản chi");


     }
   return v ;
}
}
