package com.baitap.sin.quanli;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Bieudo_Activity extends AppCompatActivity {
    Spinner spibieudo ;
    BarChart chart ;


  private    int c = 0 ;
   private int d = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bieudo_);
        spibieudo = (Spinner) findViewById(R.id.spinbieudo);



        spibieudo.setOnItemSelectedListener(spinclick);



      chart = (BarChart) findViewById(R.id.chart);

        BarData data = new BarData(getXAxisValues(), getDataSet());
        chart.setData(data);
        chart.setDescription("Quản lí chi tiêu");
        chart.animateXY(1500, 1500);
        chart.invalidate();
    }

    public ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();

        BarEntry v1e1 = new BarEntry(c,0) ; // Jan
        valueSet1.add(v1e1);


        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
       BarEntry v2e1 = new BarEntry(d,0); // Jan
        valueSet2.add(v2e1);


        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Tổng thu");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Tổng chi");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("");

        return xAxis;
    }


    AdapterView.OnItemSelectedListener spinclick = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position==0){
                c = 50 ;
                d = 30 ;
                BarData data = new BarData(getXAxisValues(), getDataSet());
                chart.setData(data);
                chart.setDescription("Quản lí chi tiêu");
                chart.animateXY(1500, 1500);
                chart.invalidate();




            }
            if (position==1){
                c = 1670 ;
                d = 570 ;
                BarData data = new BarData(getXAxisValues(), getDataSet());
                chart.setData(data);
                chart.setDescription("Quản lí chi tiêu");
                chart.animateXY(1500, 1500);
                chart.invalidate();


            }
            if (position==2){
                c = 15560 ;
                d = 8930 ;
                BarData data = new BarData(getXAxisValues(), getDataSet());
                chart.setData(data);
                chart.setDescription("Quản lí chi tiêu");
                chart.animateXY(1500, 1500);
                chart.invalidate();


            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


}
