package com.haiha.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = findViewById(R.id.tv_Hoten2);
        tv2 = findViewById(R.id.tv_Date2);
        tv3 = findViewById(R.id.tv_Truong2);
        tv4 = findViewById(R.id.tv_GT2);
        tv5 = findViewById(R.id.tv_hobby2);

        Intent intent = getIntent();
        tv1.setText(intent.getExtras().get("Ho ten").toString());
        tv2.setText(intent.getExtras().get("Ngay thang nam sinh").toString());
        tv3.setText(intent.getExtras().get("Truong").toString());
        tv4.setText(intent.getExtras().get("Giới tính").toString());
        tv5.setText(intent.getExtras().get("Sở thích").toString());
    }
}