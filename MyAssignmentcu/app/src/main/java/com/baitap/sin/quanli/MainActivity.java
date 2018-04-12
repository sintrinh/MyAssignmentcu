package com.baitap.sin.quanli;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtus , edtpas ;
    Button btnlogin ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtus = (EditText) findViewById(R.id.edtuser);
        edtpas= (EditText) findViewById(R.id.edtpass);
        btnlogin= (Button) findViewById(R.id.btnlogin);
        edtus.setText("sintrinh");
        edtpas.setText("2310");
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtus.getText().toString().equals("sintrinh") && edtpas.getText().toString().equals("2310")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công !!!", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(getApplicationContext(),quanlithuchi.class);
                    startActivity(intent1);
                }
                else {
                    Toast.makeText(MainActivity.this, "Mật khẩu hoặc tên đăng nhập sai !", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
