package com.baitap.sin.quanli;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    //khai báo tên data và phiên bản data

    final static int DATABASE_VERSION = 1;
    final static String DATABASE_NAME ="quanlithuchi_database";

    // khai báo biến context
    Context context;

    // khai báo bảng  tab cài đặt (thuchi --> khoản thu hoặc khoản chi  -> gán trực tiếp giá trị vào trước)

    public static final String TABLE_CAIDAT_LOAITHUCHI = "tb_loaithuchi";
    public static final String KEY_IDTHUCHI = "_idloaithuchi";
    public static final String KEY_LOAITHUCHI = "loaithuchi";


    //khai báo bảng tài khoản
    public static final String TABLE_TAIKHOAN = "tb_taikhoan";
    public static final String KEY_ID_TAIKHOAN = "_idtaikhoan";
    public static final String KEY_TEN_LOAITK = "loaitaikhoan";
    public static final String KEY_SOTIEN_LOAITK= "sotientaikhoan";
    public static final String KEY_ID_LOAITHUCHI = "id_loaithuchi"; //khoá ngoại _idloaithuchi



    // khai báo bản KHOẢN  thu chi

    public static final String TABLE_TENKHOANTHUCHI = "tb_khoanthuchi";
    public static final String KEY_IDKHOANTHUCHI = "_idkhoanthuchi";
    public static final String KEY_NAMEKHOANTHUCHI = "namekhoanthuchi";
    public static final String KEY_IDD_LOAITHUCHI = "idd_loaithuchi"; //khoá ngoại _idloaithuchi


    // khai báo bảng giao dịch thu chi

    public static final String TABLE_GIAODICHTHUCHI = "tb_giaodich";
    public static final String KEY_IDGDTHUCHI = "_idgiaodich";
    public static final String KEY_TAIKHOAN = "taikhoan";
    public static final String KEY_LOAIGD = "loaigd"; //khoá ngoại
    public static final String KEY_PHANNHOM= "phannhom";
    public static final String KEY_TIEN= "sotiengd";
    public static final String KEY_LYDO = "lydo";
    public static final String KEY_DATEGD = "dategiaodich";
    //public static final String KEY_IDDTAIKHOAN = "iddtaikhoan"; //khoá ngoại
  // public static final String KEY_IDDD_LOAITHUCHI = "iddd_loaithuchi"; //khoá ngoại

   // public static final String KEY_TIMEGD = "timegiaodich";







    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
      this.context = context ;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        caidat cd = new caidat() ;
        Taikhoan tk = new Taikhoan() ;

        // tạo bảng  TABLE_CAIDAT_LOAITHUCHI
        String CREATE_TABLE_CAIDAT_LOAITHUCHI = "CREATE TABLE " + TABLE_CAIDAT_LOAITHUCHI + " ("
                + KEY_IDTHUCHI + " INTEGER PRIMARY KEY,"
                + KEY_LOAITHUCHI + " nvarchar)";
        db.execSQL(CREATE_TABLE_CAIDAT_LOAITHUCHI);

        //Thêm 2 loại thu chi (khoản thu, khoản chi vào bảng vừa tạo )
        values.put(KEY_IDTHUCHI,1);
        values.put(KEY_LOAITHUCHI,"KHOẢN THU");
        if (db.insert(TABLE_CAIDAT_LOAITHUCHI,null,values) !=-1){
            Toast.makeText(context,"them thanh cong"+cd.getCaidat_Id(),Toast.LENGTH_SHORT).show();
        }  else{Toast.makeText(context,"them that bai",Toast.LENGTH_SHORT).show();}



        values.put(KEY_IDTHUCHI,2);
        values.put(KEY_LOAITHUCHI,"KHOẢN CHI");
        if (db.insert(TABLE_CAIDAT_LOAITHUCHI,null,values) !=-1){
            Toast.makeText(context,"thêm thành công"+cd.getCaidat_Id(),Toast.LENGTH_SHORT).show();
        }  else{Toast.makeText(context,"thêm thất bại",Toast.LENGTH_SHORT).show();}





//        // tạo bảng và xử lí bảng TABLE_TAIKHOAN
//
//        String CREATE_TABLE_TAIKHOAN = "CREATE TABLE " + TABLE_TAIKHOAN + " ("
//                + KEY_ID_TAIKHOAN + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + KEY_TEN_LOAITK + " nvarchar,"
//                + KEY_SOTIEN_LOAITK+" INTEGER";
//
//        db.execSQL(CREATE_TABLE_TAIKHOAN);
//        ContentValues values2= new ContentValues();
//        //Thêm ba loại tài khoản vào : tiền mặt , tín dụng , tiết kiệm
//        values2.put(KEY_ID_TAIKHOAN, 0);
//        values2.put(KEY_TEN_LOAITK, "Tiền mặt");
//        if (db.insert(TABLE_TAIKHOAN,null,values) !=-1){
//            Toast.makeText(context,"thêm thành công",Toast.LENGTH_SHORT).show();
//        }  else{Toast.makeText(context,"thêm thất bại",Toast.LENGTH_SHORT).show();}
//
//
//
//        //Thêm ba loại tài khoản vào : tiền mặt , tín dụng , tiết kiệm
//        values2.put(KEY_ID_TAIKHOAN, 1);
//        values2.put(KEY_TEN_LOAITK, "Tín dụng");
//
//        if (db.insert(TABLE_TAIKHOAN,null,values) !=-1){
//            Toast.makeText(context,"thêm thành công",Toast.LENGTH_SHORT).show();
//        }  else{Toast.makeText(context,"thêm thất bại",Toast.LENGTH_SHORT).show();}
//
//
//
//
//        //Thêm ba loại tài khoản vào : tiền mặt , tín dụng , tiết kiệm
//        values2.put(KEY_ID_TAIKHOAN, 2);
//        values2.put(KEY_TEN_LOAITK,"Tín dụng");
//        if (db.insert(TABLE_TAIKHOAN,null,values) !=-1){
//            Toast.makeText(context,"thêm thành công",Toast.LENGTH_SHORT).show();
//        }  else{Toast.makeText(context,"thêm thất bại",Toast.LENGTH_SHORT).show();}






        // tạo bảng  khoản thu chi

        String CREAT_TABLE_TENKHOANTHUCHI = "CREATE TABLE " + TABLE_TENKHOANTHUCHI + " ("
                + KEY_IDKHOANTHUCHI + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAMEKHOANTHUCHI + " nvarchar,"
                + KEY_IDD_LOAITHUCHI+" INTEGER NOT NULL)";
        db.execSQL(CREAT_TABLE_TENKHOANTHUCHI);

        // tạo bảng thêm giao dịch

        String CREATE_TABLE_GIAODICH = "CREATE TABLE " + TABLE_GIAODICHTHUCHI + " ("
                + KEY_IDGDTHUCHI + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_TAIKHOAN + " nvarchar,"
                + KEY_LOAIGD +" nvarchar,"
                + KEY_PHANNHOM +" nvarchar,"
                + KEY_TIEN + " INTEGER,"
                + KEY_LYDO +" nvarchar,"
                + KEY_DATEGD + " DATETIME)";
        db.execSQL(CREATE_TABLE_GIAODICH);







    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS "+TABLE_CAIDAT_LOAITHUCHI);
        onCreate(db);
    }


    //select
    public Cursor GetData(String sql){
        SQLiteDatabase db= getWritableDatabase();
        return db.rawQuery(sql, null);
    }


    // lấy danh sách từ bảng  TABLE_CAIDAT_LOAITHUCHI
    public List<caidat> getkhoanthukhoanchi(){
        List<caidat> list= new ArrayList<caidat>();
        SQLiteDatabase db= this.getWritableDatabase();
        String sql="select * from "+TABLE_CAIDAT_LOAITHUCHI;
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            caidat thuChi= new caidat();
            thuChi.setCaidat_Id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_IDTHUCHI))));
            thuChi.setTenkhoanthuchi(cursor.getString(cursor.getColumnIndex(KEY_LOAITHUCHI)));
            list.add(thuChi);
            cursor.moveToNext();
        }
        return list;
    }


    // Lấy danh sách khoản thu chi (Lương , tiền điện , tiền nước ...)
    public List<Tenkhoanthuchi> layds_ten_ktc(){
        List<Tenkhoanthuchi> list= new ArrayList<Tenkhoanthuchi>();
        SQLiteDatabase db= this.getWritableDatabase();
        String sql="select * from "+TABLE_TENKHOANTHUCHI;
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Tenkhoanthuchi name_ktc= new Tenkhoanthuchi();
            name_ktc.setIdkhoanthuchi(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_IDKHOANTHUCHI))));
            name_ktc.setTenkhoanthuchi(cursor.getString(cursor.getColumnIndex(KEY_NAMEKHOANTHUCHI)));
            name_ktc.setIddngoaithuchi(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_IDD_LOAITHUCHI))));

            list.add(name_ktc);
            cursor.moveToNext();
        }
        return list;
    }

    // thêm khoản thu chi (Lương , tiền điện , tiền nước ...)

    public void themkhoanthuchi(Tenkhoanthuchi tenkhoanthuchi){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(KEY_NAMEKHOANTHUCHI, tenkhoanthuchi.getTenkhoanthuchi());
      values.put(KEY_IDD_LOAITHUCHI, tenkhoanthuchi.getIddngoaithuchi());
        if(db.insert(TABLE_TENKHOANTHUCHI, null, values)!=-1){
            Toast.makeText(context,"thêm thành công",Toast.LENGTH_SHORT).show();
        }
        else{Toast.makeText(context,"thêm thất bại",Toast.LENGTH_SHORT).show();};
    }


//   // Lấy danh sách TABLE_TAIKHOAN
//
//    public List<Taikhoan> lay_ds_taikhoan(){
//        List<Taikhoan> listtk = new ArrayList<Taikhoan>();
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sqlite = "select * from " +TABLE_TAIKHOAN ;
//        Cursor cursor = db.rawQuery(sqlite,null);
//        while (!cursor.isAfterLast()){
//            Taikhoan tk = new Taikhoan();
//            tk.setIdtaikhoan(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID_TAIKHOAN))));
//            tk.setLoaiTaiKhoan(cursor.getString(cursor.getColumnIndex(KEY_TEN_LOAITK)));
//            tk.setSotien(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_SOTIEN_LOAITK))));
//            tk.setIdngoaithuchi(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID_LOAITHUCHI))));
//
//            listtk.add(tk);
//            cursor.moveToNext();
//        }
//        return listtk ;
//    }
     // Thêm giao dịch
public void themgiaodich(viewds_class giaoDich){

    SQLiteDatabase db= this.getWritableDatabase();
    ContentValues values= new ContentValues();
    values.put(KEY_TAIKHOAN,giaoDich.getTaikhoan());
    values.put(KEY_LOAIGD,giaoDich.getLoaigiaodich());
    values.put(KEY_PHANNHOM,giaoDich.getPhannhom());
    values.put(KEY_LYDO,giaoDich.getLydo());
    values.put(KEY_TIEN, giaoDich.getSotien());
    values.put(KEY_DATEGD, giaoDich.getNgay());
    if(db.insert(TABLE_GIAODICHTHUCHI, null, values)!=-1){
        Toast.makeText(context,"Thêm thành công",Toast.LENGTH_SHORT).show();
    }
    else{Toast.makeText(context,"them that bai",Toast.LENGTH_SHORT).show();};
}





    // lấy giao dịch


    public List<viewds_class> laydsgiaodich(){
        List<viewds_class> list= new ArrayList<viewds_class>();
        SQLiteDatabase db= this.getWritableDatabase();
        String sql="select * from "+TABLE_GIAODICHTHUCHI;
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            viewds_class giaoDich= new viewds_class();

           giaoDich.setMagd(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_IDGDTHUCHI))));
            giaoDich.setTaikhoan(cursor.getString(cursor.getColumnIndex(KEY_TAIKHOAN)));
//           giaoDich.setIdthuchi(cursor.getString(cursor.getColumnIndex(KEY_KHOANLOAITHUCHI)));
            giaoDich.setLoaigiaodich(cursor.getString(cursor.getColumnIndex(KEY_LOAIGD)));
            giaoDich.setPhannhom(cursor.getString(cursor.getColumnIndex(KEY_PHANNHOM)));
            giaoDich.setLydo(cursor.getString(cursor.getColumnIndex(KEY_LYDO)));
            giaoDich.setSotien(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_TIEN))));
            giaoDich.setNgay(cursor.getString(cursor.getColumnIndex(KEY_DATEGD)));
            list.add(giaoDich);
            cursor.moveToNext();
        }
        return list;
    }


    // xoá item

    public boolean deleteitem (int id){
        boolean result = true ;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLE_TENKHOANTHUCHI, "_idkhoanthuchi = " + id, null);
        } catch (Exception ex) {
            result = false;
        } finally {
            db.close();
            return result;
        }



    }

}



