package com.baitap.sin.quanli;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class quanlithuchi extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int sotk;
    List<caidat> caidat_list;

    List<Tenkhoanthuchi> list_name_ktc;
    List<Tenkhoanthuchi> ktc_list;
    List<Tenkhoanthuchi> list_all_ktc;
    Tenkhoanthuchi name_ktc ;

    MyDatabaseHelper db;







    // TAB1 (TAB THU CHI)  ============================================================================>
     Button btnthemgd , btnhomnay ,btntuannay , btnthangnay ,btnnamnay , btnxembieudo ;
    TextView txtthetindung , txttienmat ,txttientietkiem , txtsodu ;


    //TAB2 (TAB THỐNG KÊ)  ============================================================================>
     Spinner spinnerthongke ;
    ListView lv_thongke_tongthu ,lv_thongke_tongchi ;



    //TAB3 (TAB CÀI ĐẶT)  ============================================================================>
    Spinner spinner_caidat_phannhom , spinner_caidat_item ;
    ListView lv_caidat ;
    ImageButton btn_caidat_add ;
    EditText edt_caidat ;
    caidat cd ;


    int spinlv;
    int spinitem;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlithuchi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // LOAD TAB  ============================================================================>

        loadtab();



        // ÁNH XẠ

            // thuchi_tab  ============================================================================>
             anhxathuchitab();

            //thongke_tab  ============================================================================>

            anhxathongketab();

            //caidat_tab  ============================================================================>


            anhxacaidattab();

        //BẮT SỰ KIỆN BUTTON  ============================================================================>
        //thuchi_tab  ============================================================================>
        thuchi_tab_onclick();

        //thongke_tab  ============================================================================>
        thongke_tab_onclick();

        //caidat_tab  ============================================================================>

        caidat_tab_onclick();


        //XỬ LÍ JAVA TRÊN TỪNG TAB ============================================================================>


        //TAB_THU_CHI  ============================================================================>
        thuchijava();


        ////


        //TAB_THONG_KE  ============================================================================>
             thongkejava();


        //TAB_CAI_DAT  ============================================================================>
                caidatjava();







//        btnthemgd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(getApplicationContext(),themgiaodich_activity.class);
//                startActivity(intent1);
//            }
//        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }




    private void loadtab() {
        final TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
        tab.setup();
        TabHost.TabSpec spec;

        // tạo tab  ============================================================================>

        spec=tab.newTabSpec("t1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Thu Chi");
        tab.addTab(spec);
        //Tạo tab2
        spec=tab.newTabSpec("t2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Thống Kê");
        tab.addTab(spec);
        // tab3
        spec=tab.newTabSpec("t3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Cài Đặt");
        tab.addTab(spec);
        //Thiết lập tab mặc định được chọn ban đầu là tab 0
        tab.setCurrentTab(0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quanlithuchi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // sự kiện refresh

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title
            alertDialogBuilder.setTitle("Cập nhật dữ liệu !");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Chọn có để cập nhật !")
                    .setCancelable(false)
                    .setPositiveButton("Có",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                            Intent intent3 = new Intent(getApplicationContext(),quanlithuchi.class);
                            startActivity(intent3);
                            Toast.makeText(quanlithuchi.this, "Dữ liệu đã được cập nhật", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .setNegativeButton("Không",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();



            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

          if (id == R.id.nav_gallery) {

              final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
              // khởi tạo dialog
              alertDialogBuilder.setMessage(" Giúp bạn quản lí thu chi tốt hơn !"+"\n" +"\n"+"\n"+"Sản phẩm của : TienHuynh");
              // thiết lập nội dung cho dialog

              AlertDialog alertDialog = alertDialogBuilder.create();
              // tạo dialog
              alertDialog.show();
              // hiển thị dialog

        }  else if (id == R.id.nav_manage) {

              final AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(this);
              // khởi tạo dialog
              alertDialogBuilder1.setMessage("Phiên bản : 1.0 for Android 4.4.2");
              // thiết lập nội dung cho dialog

              AlertDialog alertDialog = alertDialogBuilder1.create();
              // tạo dialog
              alertDialog.show();
              // hiển thị dialog

        } else if (id == R.id.nav_share) {



        } else if (id == R.id.nav_send) {

              Intent it = new Intent(getApplicationContext(),Main2Activity.class);
              startActivity(it);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // ÁNH XẠ TAB_THU_CHI  ============================================================================>
    public void anhxathuchitab(){
        btnthemgd= (Button) findViewById(R.id.btnthemgiaodich);
        btnhomnay = (Button) findViewById(R.id.btnhomnay);
        btntuannay = (Button) findViewById(R.id.btntuannay);
        btnthangnay = (Button) findViewById(R.id.btnthangnay);
        btnnamnay = (Button) findViewById(R.id.btnnamnay);
        btnxembieudo = (Button) findViewById(R.id.btnxembieudo);
        txttienmat = (TextView) findViewById(R.id.txttienmat);
        txtthetindung = (TextView) findViewById(R.id.txttindung);
        txttientietkiem = (TextView) findViewById(R.id.txttietkiem);
        txtsodu = (TextView) findViewById(R.id.txtsodu);


    }

    // ÁNH XẠ TAB_THỐNG_KÊ  ============================================================================>
    public void anhxathongketab(){
        spinnerthongke = (Spinner) findViewById(R.id.spinthongke);
        lv_thongke_tongthu= (ListView) findViewById(R.id.listtongthuthongke);
        lv_thongke_tongchi= (ListView) findViewById(R.id.listtongchithongke);

    }


    // ÁNH XẠ TAB CÀI ĐẶT  ============================================================================>
     public void anhxacaidattab(){
         spinner_caidat_phannhom= (Spinner) findViewById(R.id.spin_caidat_phannhom);
         spinner_caidat_item= (Spinner) findViewById(R.id.spnkhoan);
         lv_caidat = (ListView) findViewById(R.id.lv_caidat);
         edt_caidat= (EditText) findViewById(R.id.edt_caidat);
         btn_caidat_add= (ImageButton) findViewById(R.id.btn_caidat_add);

     }

    //BẮT SỰ KIỆN CÁC BUTTON  ============================================================================>
        //THUCHI_TAB_ONCLICK ============================================================================>
            public void thuchi_tab_onclick(){
                btnthemgd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent(quanlithuchi.this,themgiaodich_activity.class);
                       startActivity(intent1);

                    }
                });

                btnhomnay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent2 = new Intent(quanlithuchi.this,Viewgd_activity.class);
                        startActivity(intent2);

                    }
                });
                btntuannay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent2 = new Intent(quanlithuchi.this,Viewgd_activity.class);
                        startActivity(intent2);

                    }
                });
                btnthangnay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent2 = new Intent(quanlithuchi.this,Viewgd_activity.class);
                        startActivity(intent2);

                    }
                });
                btnnamnay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent2 = new Intent(quanlithuchi.this,Viewgd_activity.class);
                        startActivity(intent2);

                    }
                });
                btnxembieudo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intentb = new Intent(getApplicationContext(),Bieudo_Activity.class);
                        startActivity(intentb);

                    }
                });




            }



    //THONGKE_TAB_ONCLICK ============================================================================>
        public void thongke_tab_onclick(){

        }

    //CAIDAT_TAB_ONCLICK ============================================================================>

    public void caidat_tab_onclick(){

    }


    //XỬ LÍ JAVA TRÊN TỪNG TAB ============================================================================>

        //TAB_THU_CHI  ============================================================================>

    public  void  thuchijava (){
        //gọi sql
        db = new MyDatabaseHelper(this);


//////
        List <viewds_class> laytienmatall = new  ArrayList<viewds_class>();
        laytienmatall = db.laydsgiaodich();

        int sotien = 0;





        ///// Lấy Tiền Mặt
        List <viewds_class> laytienmat = new ArrayList<viewds_class>();

        for (int i=0;i<laytienmatall.size();i++){

            if(laytienmatall.get(i).getTaikhoan().equals("Tiền Mặt")){
                laytienmat.add(new viewds_class(
                        laytienmatall.get(i).getMagd(),
                        laytienmatall.get(i).getTaikhoan(),
                        laytienmatall.get(i).getLoaigiaodich(),
                        laytienmatall.get(i).getPhannhom(),
                        laytienmatall.get(i).getSotien(),
                        laytienmatall.get(i).getLydo(),
                        laytienmatall.get(i).getNgay()

                ));
                sotien = laytienmat.get(i).getSotien() +sotien ;

                txttienmat.setText(String.valueOf(sotien));


            }



        }




        ////// Lấy tiết kiệm

        List <viewds_class> laytietkiem = new ArrayList<viewds_class>();

        laytienmatall=db.laydsgiaodich();
        for (int i=0;i<laytienmatall.size();i++){

            if(laytienmatall.get(i).getTaikhoan().equals("Tiết kiệm")){
                laytietkiem.add(new viewds_class(
                        laytienmatall.get(i).getMagd(),
                        laytienmatall.get(i).getTaikhoan(),
                        laytienmatall.get(i).getLoaigiaodich(),
                        laytienmatall.get(i).getPhannhom(),
                        laytienmatall.get(i).getSotien(),
                        laytienmatall.get(i).getLydo(),
                        laytienmatall.get(i).getNgay()

                ));
                sotk = laytienmatall.get(i).getSotien() + sotk ;

               txttientietkiem.setText(String.valueOf(sotk));

            }



        }











        //// lấy tín dụng

        int sotindung = 0 ;

        List <viewds_class> laytindung = new ArrayList<viewds_class>();

        laytienmatall=db.laydsgiaodich();
        for (int i=0;i<laytienmatall.size();i++){

            if(laytienmatall.get(i).getTaikhoan().equals("Tín dụng")){
                laytindung.add(new viewds_class(
                        laytienmatall.get(i).getMagd(),
                        laytienmatall.get(i).getTaikhoan(),
                        laytienmatall.get(i).getLoaigiaodich(),
                        laytienmatall.get(i).getPhannhom(),
                        laytienmatall.get(i).getSotien(),
                        laytienmatall.get(i).getLydo(),
                        laytienmatall.get(i).getNgay()

                ));
                sotindung = laytienmatall.get(i).getSotien() + sotindung ;

                txtthetindung.setText(String.valueOf(sotindung));

            }



            }

        int sodu = sotien + sotk - sotindung ;
        txtsodu.setText(String.valueOf(sodu));

    }
















        //TAB_THONG_KE  ============================================================================>

        public void thongkejava(){
            // gọi sql

            db = new MyDatabaseHelper(this);

            ArrayList<String> arr_spi_thongke = new ArrayList<String>();
            arr_spi_thongke.add("Hôm nay");
            arr_spi_thongke.add("Tuần này");
            arr_spi_thongke.add("Tháng này");
            arr_spi_thongke.add("Năm này");
            ArrayAdapter<String> adapter_spi_thongke = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked , arr_spi_thongke);
            spinnerthongke.setAdapter(adapter_spi_thongke);

            spinnerthongke.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(position==0){


                        // list tổng thu
                        //  ListView lv_thongke_tongthu ,lv_thongke_tongchi ;

                        // list tổng thu
                        List<viewds_class> arrtongthu = new ArrayList<viewds_class>();
                        arrtongthu = db.laydsgiaodich();
                        List<viewds_class> arrtt = new ArrayList<viewds_class>();
                        for (int i=0;i<arrtongthu.size();i++){
                            if(arrtongthu.get(i).getLoaigiaodich().equals("KHOẢN THU")){
                                arrtt.add(new viewds_class(
                                        arrtongthu.get(i).getMagd(),
                                        arrtongthu.get(i).getTaikhoan(),
                                        arrtongthu.get(i).getLoaigiaodich(),
                                        arrtongthu.get(i).getPhannhom(),
                                        arrtongthu.get(i).getSotien(),
                                        arrtongthu.get(i).getLydo(),
                                        arrtongthu.get(i).getNgay()

                                ));
                            } else {

                            }
                        }

                       // Toast.makeText(getApplicationContext(),arrtongthu.toString(),Toast.LENGTH_SHORT).show();
                        list_adapter_thongke adttk = new list_adapter_thongke(getApplicationContext(),R.layout.custom_list_caidat,arrtt);
                        lv_thongke_tongthu.setAdapter(adttk);







                        ////////////////////

                        // list tổng chi
                        List<viewds_class> arrtongchi = new ArrayList<viewds_class>();
                        arrtongchi = db.laydsgiaodich();
                        List<viewds_class> arrtc = new ArrayList<viewds_class>();
                        for (int i=0;i<arrtongchi.size();i++){
                            if(arrtongchi.get(i).getLoaigiaodich().equals("KHOẢN CHI")){
                                arrtc.add(new viewds_class(
                                        arrtongchi.get(i).getMagd(),
                                        arrtongchi.get(i).getTaikhoan(),
                                        arrtongchi.get(i).getLoaigiaodich(),
                                        arrtongchi.get(i).getPhannhom(),
                                        arrtongchi.get(i).getSotien(),
                                        arrtongchi.get(i).getLydo(),
                                        arrtongchi.get(i).getNgay()

                                ));
                            } else {

                            }
                        }
                   //     Toast.makeText(getApplicationContext(),arrtongchi.toString(),Toast.LENGTH_SHORT).show();
                        list_adapter_thongke adttc = new list_adapter_thongke(getApplicationContext(),R.layout.custom_list_caidat,arrtc);
                        lv_thongke_tongchi.setAdapter(adttc);









                    }

                    if (position==1){

                        // thu
                        ArrayList<viewds_class> arrtuan = new ArrayList<viewds_class>();
                        arrtuan.add(new viewds_class(1,"tm","kc","Lương",10000,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Trợ cấp",2000,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Lãi",150,"t","t"));



                        list_adapter_thongke adtt = new list_adapter_thongke(getApplicationContext(),R.layout.custom_list_caidat,arrtuan);

                        lv_thongke_tongthu.setAdapter(adtt);




                        //// chi
                        ArrayList<viewds_class> arrchituan = new ArrayList<viewds_class>();
                        arrchituan.add(new viewds_class(1,"tm","kc","Tiền ăn",1200,"t","t"));
                        arrchituan.add(new viewds_class(1,"tm","kc","Tiền điện thoại",1000,"t","t"));




                        list_adapter_thongke adtv = new list_adapter_thongke(getApplicationContext(),R.layout.custom_list_caidat,arrchituan);

                        lv_thongke_tongchi.setAdapter(adtv);










                    }

                    if(position == 2){
                        // thu
                        ArrayList<viewds_class> arrtuan = new ArrayList<viewds_class>();
                        arrtuan.add(new viewds_class(1,"tm","kc","Lương",10000,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Trợ cấp",2000,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Lãi",150,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Bảo Hiểm",1200,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Kinh Doanh",200,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Vật phẩm",350,"t","t"));



                        list_adapter_thongke adtt = new list_adapter_thongke(getApplicationContext(),R.layout.custom_list_caidat,arrtuan);

                        lv_thongke_tongthu.setAdapter(adtt);




                        //// chi
                        ArrayList<viewds_class> arrchituan = new ArrayList<viewds_class>();
                        arrchituan.add(new viewds_class(1,"tm","kc","Tiền ăn",1200,"t","t"));
                        arrchituan.add(new viewds_class(1,"tm","kc","Tiền điện",1000,"t","t"));
                        arrchituan.add(new viewds_class(1,"tm","kc","Tiền Chơi",500,"t","t"));

                        arrchituan.add(new viewds_class(1,"tm","kc","Tiền uống",200,"t","t"));

                        arrchituan.add(new viewds_class(1,"tm","kc","Đầu tư",14500,"t","t"));





                        list_adapter_thongke adtv = new list_adapter_thongke(getApplicationContext(),R.layout.custom_list_caidat,arrchituan);

                        lv_thongke_tongchi.setAdapter(adtv);




                    }

                    if(position==3){

                        // thu
                        ArrayList<viewds_class> arrtuan = new ArrayList<viewds_class>();
                        arrtuan.add(new viewds_class(1,"tm","kc","Lương",10000,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Trợ cấp",2000,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Lãi",150,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Bảo Hiểm",1200,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Kinh Doanh",200,"t","t"));
                        arrtuan.add(new viewds_class(1,"tm","kc","Vật phẩm",350,"t","t"));



                        list_adapter_thongke adtt = new list_adapter_thongke(getApplicationContext(),R.layout.custom_list_caidat,arrtuan);

                        lv_thongke_tongthu.setAdapter(adtt);




                        //// chi
                        ArrayList<viewds_class> arrchituan = new ArrayList<viewds_class>();
                        arrchituan.add(new viewds_class(1,"tm","kc","Tiền ăn",1200,"t","t"));
                        arrchituan.add(new viewds_class(1,"tm","kc","Tiền điện",1000,"t","t"));
                        arrchituan.add(new viewds_class(1,"tm","kc","Tiền Chơi",500,"t","t"));

                        arrchituan.add(new viewds_class(1,"tm","kc","Tiền uống",200,"t","t"));

                        arrchituan.add(new viewds_class(1,"tm","kc","Đầu tư",14500,"t","t"));





                        list_adapter_thongke adtv = new list_adapter_thongke(getApplicationContext(),R.layout.custom_list_caidat,arrchituan);

                        lv_thongke_tongchi.setAdapter(adtv);


                    }


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            }); }



            ////////////////////////////////////








        //TAB_CAI_DAT  ============================================================================>
          public void   caidatjava(){


              db = new MyDatabaseHelper(this);

              // gán dữ liệu vào spiner phân nhóm
              cd = new caidat();
              caidat_list = new ArrayList<caidat>();
              caidat_list = db.getkhoanthukhoanchi();
              cd.setCaidat_Id(0);
              cd.setTenkhoanthuchi("TỎNG HỢP");
              caidat_list.add(cd);

              final ArrayAdapter arrayAdapter2 = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item, caidat_list);
              spinner_caidat_phannhom.setAdapter(arrayAdapter2);


              // gán dữ liệu vào spinner item
              caidat_list = new ArrayList<caidat>();
              caidat_list = db.getkhoanthukhoanchi();
              final ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.spinner_item, caidat_list);
              spinner_caidat_item.setAdapter(arrayAdapter);


              //// bắt sự kiện các spinner

              spinner_caidat_item.setOnItemSelectedListener(SpinItemselect);
           spinner_caidat_phannhom.setOnItemSelectedListener(Spinphannhomselect);


              /// bắt sự kiện nút add_caidat

              btn_caidat_add.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {

                      String tenkhoanthuchi = edt_caidat.getText().toString();
                      Toast.makeText(getApplicationContext(), "" + tenkhoanthuchi, Toast.LENGTH_SHORT).show();
                      name_ktc = new Tenkhoanthuchi();
                      name_ktc.setTenkhoanthuchi(tenkhoanthuchi);
                      name_ktc.setIddngoaithuchi(spinitem);
                      db.themkhoanthuchi(name_ktc);
                      edt_caidat.setText("");
                      if (spinlv == 1 && spinitem == 1) {
                          gandulieu_ktc(spinlv);
                      }
                      if (spinlv == 2 && spinitem == 2) {
                          gandulieu_ktc(spinlv);
                      }
                      if (spinlv == 0) trave_dulieu();
                  }









              });






              // xoá item
              lv_caidat.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                  @Override
                  public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                      final int   c =  list_all_ktc.get(position).getIdkhoanthuchi();


                      AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(quanlithuchi.this);


                      alertDialogBuilder.setTitle("Xoá");

                      // set dialog message
                      alertDialogBuilder
                              .setMessage("Bạn có muốn xoá dữ liệu này ?")
                              .setCancelable(false)
                              .setPositiveButton("Có",new DialogInterface.OnClickListener() {
                                  public void onClick(DialogInterface dialog,int id) {
                                      // if this button is clicked, close
                                      // current activity

                                      db.deleteitem(c);
                                      Intent intent3 = new Intent(getApplicationContext(),quanlithuchi.class);
                                      startActivity(intent3);
                                      Toast.makeText(quanlithuchi.this, "Đã xoá !!!", Toast.LENGTH_SHORT).show();

                                  }
                              })
                              .setNegativeButton("Không",new DialogInterface.OnClickListener() {
                                  public void onClick(DialogInterface dialog,int id) {
                                      // if this button is clicked, just close
                                      // the dialog box and do nothing
                                      dialog.cancel();
                                  }
                              });

                      // create alert dialog
                      AlertDialog alertDialog = alertDialogBuilder.create();

                      // show it
                      alertDialog.show();










                      return false;
                  }
              });









































}           // gán sự kiện cho spinner
    AdapterView.OnItemSelectedListener SpinItemselect = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (position == 0) {
                spinitem = caidat_list.get(position).getCaidat_Id();
            }
            if (position == 1) {
                spinitem = caidat_list.get(position).getCaidat_Id();
            }
            if (position == 2) {
                spinitem = caidat_list.get(position).getCaidat_Id();
            }


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }



    };

    AdapterView.OnItemSelectedListener Spinphannhomselect= new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (position == 0) {
                spinlv = caidat_list.get(position).getCaidat_Id();
                gandulieu_ktc(spinlv);

            }
            if (position == 1) {
                spinlv = caidat_list.get(position).getCaidat_Id();
                gandulieu_ktc(spinlv);
            }
            if (position == 2) {
                trave_dulieu();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    // lấy dữ liệu
    public boolean gandulieu_ktc(int idclass) {
        boolean b = true;
        list_name_ktc = new ArrayList<Tenkhoanthuchi>();
        list_all_ktc = db.layds_ten_ktc();
        for (int i = 0; i < list_all_ktc.size(); i++) {
            if (idclass == list_all_ktc.get(i).getIddngoaithuchi()) {
                list_name_ktc.add(new Tenkhoanthuchi(
                        list_all_ktc.get(i).getIdkhoanthuchi(),
                        list_all_ktc.get(i).getTenkhoanthuchi(),
                        list_all_ktc.get(i).getIddngoaithuchi()
                ));
            } else {
            }
        }
        final list_adapter_caidat adapter = new list_adapter_caidat(getApplicationContext(), R.layout.custom_list_caidat, list_name_ktc);
        lv_caidat.setAdapter(adapter);
        return b;
    }

    // trả về dữ liệu
    public void trave_dulieu() {
        ktc_list = new ArrayList<Tenkhoanthuchi>();
        ktc_list = db.layds_ten_ktc();
        final list_adapter_caidat adapter = new list_adapter_caidat(getApplicationContext(), R.layout.custom_list_caidat, ktc_list);
        lv_caidat.setAdapter(adapter);
    }














    }



