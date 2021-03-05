package com.haiha.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText e1,e2,e3;
    RadioButton r1,r2;
    CheckBox c1,c2,c3;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.et_Hoten);
        e2 = findViewById(R.id.et_Date);
        e3 = findViewById(R.id.tv_Truong2);

        r1 = findViewById(R.id.rb_nam);
        r2 = findViewById(R.id.rb_nu);

        c1 = findViewById(R.id.cb_sport);
        c2 = findViewById(R.id.cb_travel);
        c3 = findViewById(R.id.cb_read);

        b1 = findViewById(R.id.bt_1);
        b2 = findViewById(R.id.bt_2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_2:
                e1.setText("");
                e2.setText("");
                e3.setText("");
                r1.setChecked(true);
                r2.setChecked(false);
                c1.setChecked(true);
                c2.setChecked(false);
                c3.setChecked(false);
                break;
            case R.id.bt_1:
                if(SpellCheck()){
                    Intent intent = new Intent(this, MainActivity2.class);
                    intent.putExtra("Ho ten", e1.getText().toString().trim());
                    intent.putExtra("Ngay thang nam sinh", e2.getText().toString().trim());
                    intent.putExtra("Truong", e3.getText().toString().trim());
                    intent.putExtra("Giới tính", Check());
                    intent.putExtra("Sở thích", CheckBox());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "Chữ cái đầu tiên của tên phải viết hoa hoặc bạn phải điền đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    public boolean SpellCheck(){
        String string = e1.getText().toString().trim();
        String string2 = "";
        for(int i=string.length()-1;i>=0;i--){
            if(string.charAt(i)==' '){
                break;
            }
            string2 = string2 + "" +string.charAt(i);
        }
        string2 = string2.trim();
        if(string2.length() > 0){
            if((string2.charAt(string2.length()-1)>=65) && (string2.charAt(string2.length()-1)<=90) && (e2.getText().toString().trim().equals("")==false)&&
                    (e3.getText().toString().equals("")==false))
                return true;
        }
        return false;
    }

    public String Check(){
        if(r1.isChecked())
            return "Nam";
        return "Nữ";
    }
    public String CheckBox(){
        String string = "";
        if(c1.isChecked()){
            string += "Thể thao";
        }
        if(c2.isChecked()){
            string += ", Du lịch";
        }
        if(c3.isChecked()){
            string += ", Đọc sách";
        }
        return string;
    }

}