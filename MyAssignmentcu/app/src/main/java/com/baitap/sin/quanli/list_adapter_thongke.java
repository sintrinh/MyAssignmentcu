package com.baitap.sin.quanli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class list_adapter_thongke extends ArrayAdapter<viewds_class> {

    public list_adapter_thongke(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public list_adapter_thongke(Context context, int resource, List<viewds_class> items) {
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
        viewds_class tk = getItem(postion);
        if (tk != null )
        {

            ImageView img = (ImageView) v.findViewById(R.id.imgview_caidat_custom);
            TextView tvcdbig = (TextView) v.findViewById(R.id.tvbig_custom_caidat);
            tvcdbig.setText(tk.phannhom);
            TextView tvcdsmall = (TextView) v.findViewById(R.id.tvsmall_custom_caidat);
            tvcdsmall.setText(String.valueOf(tk.sotien));
        }









        return v ;
    }



}
