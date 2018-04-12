package com.baitap.sin.quanli;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class themgiaodich_activity extends ActionBarActivity {
    Dialog picker;
    Button select, hientai;

    Button set , btnluu , btndong;
    TimePicker timep;
    DatePicker datep;
    Integer hour, minute, month, day, year;
    TextView time, date;
    Spinner spntk , spnphannhom  , spinloaigd ; // phân nhóm (tiền điện tiền nươc,) ; loại gd (khoản thu khoản chi);
    EditText txtsotien,lydo ;
    List<Tenkhoanthuchi> ten_ktc ;
    List<Tenkhoanthuchi> tenktctheoid;
    List<caidat> caidats ;
    List<viewds_class> alllist;
    List<viewds_class> laydl;

    List<Taikhoan>  taikhoanList ;
    List<Taikhoan> laytaikhoanid ;
    MyDatabaseHelper db;
    List<String> list_tk ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themgiaodich_activity);
        db = new MyDatabaseHelper(this);

        // ánh xạ
        select = (Button) findViewById(R.id.btn1);
        hientai=(Button)findViewById(R.id.btn3);
        time = (TextView) findViewById(R.id.textTime);
        date = (TextView) findViewById(R.id.textDate);
        spntk= (Spinner) findViewById(R.id.spntk);
        lydo=(EditText)findViewById(R.id.txtlydo);
        txtsotien = (EditText) findViewById(R.id.txtsotien);
        spnphannhom= (Spinner) findViewById(R.id.spnphannhom);
        spinloaigd= (Spinner) findViewById(R.id.spngd);
        spinloaigd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    layds(1);
                }
                if(position==1){
                    layds(2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final TextView dateView = (TextView) findViewById(R.id.textDate);
        final TextView timeView = (TextView) findViewById(R.id.textTime);

        btnluu = (Button) findViewById(R.id.btn4);
        btndong= (Button) findViewById(R.id.btn5);

        // sự kiện btn
        btndong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themgiaodich_activity.super.finish();
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                picker = new Dialog(themgiaodich_activity.this);
                picker.setContentView(R.layout.ngaygio);
                picker.setTitle("Select Date and Time");
                datep = (DatePicker) picker.findViewById(R.id.datePicker);
                timep = (TimePicker) picker.findViewById(R.id.timePicker1);
                set = (Button) picker.findViewById(R.id.btnSet);





                //picker thời gian

                set.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Auto-generated method stub
                        month = datep.getMonth();
                        day = datep.getDayOfMonth();
                        year = datep.getYear();
                        hour = timep.getCurrentHour();
                        minute = timep.getCurrentMinute();
                        timeView.setText("Giờ: " + hour + ":" + minute);
                        dateView.setText("Ngày: " + day + "/" + month + "/"
                                + year);
                        picker.dismiss();
                    }
                });
                picker.show();
            }
        });



        // chọn thời gian
        hientai.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                String nowDate = dateFormat.format(date);

                dateView.setText(nowDate);

                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                String nowTime = timeFormat.format(date);

                timeView.setText(nowTime);
            }
        });


                    caidats = new ArrayList<caidat>();
                    caidats = db.getkhoanthukhoanchi();
                    final ArrayAdapter<caidat> adapter1 = new ArrayAdapter<caidat>(getApplicationContext(),R.layout.spinner_item,caidats);
                    spinloaigd.setAdapter(adapter1);

                ten_ktc = new ArrayList<Tenkhoanthuchi>();
                tenktctheoid=new ArrayList<>();
                ten_ktc = db.layds_ten_ktc();



      






        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewds_class vv = new viewds_class();


                vv.setTaikhoan(spntk.getSelectedItem().toString()+"");
                vv.setLoaigiaodich(spinloaigd.getSelectedItem().toString());
               // Toast.makeText(themgiaodich_activity.this, ""+spinloaigd.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                vv.setPhannhom(spnphannhom.getSelectedItem().toString());
                vv.setSotien(Integer.parseInt(txtsotien.getText().toString()));
                vv.setLydo(lydo.getText().toString());
                vv.setNgay(dateView.getText().toString());
                db.themgiaodich(vv);
                Toast.makeText(themgiaodich_activity.this, "Thêm GD thành công !!", Toast.LENGTH_SHORT).show();







            }
        });

    }
    public void layds(int id){
        ten_ktc=db.layds_ten_ktc();
        tenktctheoid=new ArrayList<>();
        for(int i=0; i<ten_ktc.size();i++){
            if (id == ten_ktc.get(i).getIddngoaithuchi()) {
                tenktctheoid.add(new Tenkhoanthuchi(
                        ten_ktc.get(i).getIdkhoanthuchi(),
                        ten_ktc.get(i).getTenkhoanthuchi(),
                        ten_ktc.get(i).getIddngoaithuchi()
                ));
            } else {
            }
            ArrayAdapter<Tenkhoanthuchi> arrayList=new ArrayAdapter<Tenkhoanthuchi>(themgiaodich_activity.this,android.R.layout.simple_list_item_1,tenktctheoid);
            spnphannhom.setAdapter(arrayList);
          //  Toast.makeText(getApplicationContext(),tenktctheoid.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}

