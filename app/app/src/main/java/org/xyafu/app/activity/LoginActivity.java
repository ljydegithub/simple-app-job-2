package org.xyafu.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import org.xyafu.app.R;
import org.xyafu.app.dao.StunNmberOpenHelper;

import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText number;
    private EditText name;
    private Button btn_in;
    private TextView register;
    private TextView forget;
    private TextView admin;
    StunNmberOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initView();
    }

    private void initView() {
        number = (EditText) findViewById(R.id.number);
        name = (EditText) findViewById(R.id.name);
        btn_in = (Button) findViewById(R.id.btn_in);
        register = (TextView) findViewById(R.id.register);
        forget = (TextView) findViewById(R.id.forget);
        admin = (TextView) findViewById(R.id.admin);

        btn_in.setOnClickListener(this);
        register.setOnClickListener(this);
        forget.setOnClickListener(this);
        admin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_in:
                if(login()){
                    Intent intent=new Intent(this, PageActivity.class);
                    intent.putExtra("stu_name",name.getText().toString());
                    intent.putExtra("stu_number",number.getText().toString());
                    startActivity(intent);
                }
                break;
            case R.id.admin:
                Intent intent01=new Intent(this, AdminLoginActivity.class);
                startActivity(intent01);
                break;
            case R.id.register:
                Intent intent02=new Intent(this, RegisterActivity.class);
                startActivity(intent02);
                break;
            case R.id.forget:
                Intent intent03=new Intent(this, ForgetActivity.class);
                startActivity(intent03);
                break;
        }
    }

    private void submit() {
        // validate
        String numberString = number.getText().toString().trim();
        if (TextUtils.isEmpty(numberString)) {
            Toast.makeText(this, "学号", Toast.LENGTH_SHORT).show();
            return;
        }

        String nameString = name.getText().toString().trim();
        if (TextUtils.isEmpty(nameString)) {
            Toast.makeText(this, "姓名", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
    }

    private boolean login(){
        boolean isSuccess=true;
        helper=new StunNmberOpenHelper(this);
        Map<String,String> map;
        map=helper.query();
        String str=map.toString();
        str=str.replace("{","");
        str=str.replace("}","");
        str=str.replace(" ","");
        String[] strs=new String[map.size()*2];
        strs=str.split("[=,]");
        for(int i=0;i<map.size()*2-1;i++){
            if(strs[i].equals(number.getText().toString())&&strs[i+1].equals(name.getText().toString())){
                Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();
                isSuccess=false;
                return true;
            }
        }
        if(isSuccess){
            Toast.makeText(this,"登陆失败",Toast.LENGTH_LONG).show();
        }
        return false;
    }
}
