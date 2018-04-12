package com.baitap.sin.quanli;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Viewgd_activity extends AppCompatActivity {
    ListView lv_viewgd ;
    List<viewds_class> arr_view = new ArrayList<viewds_class>();

    MyDatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewgd_activity);
        db = new MyDatabaseHelper(this);
        lv_viewgd = (ListView) findViewById(R.id.listviewgd);
        arr_view = db.laydsgiaodich();














        custom_viewgd adt_view = new custom_viewgd(Viewgd_activity.this,R.layout.custom_viewgd,arr_view);
        lv_viewgd.setAdapter(adt_view);


    }
}
