package org.xyafu.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.xyafu.app.R;
import org.xyafu.app.dao.StunNmberOpenHelper;

import java.util.Map;

public class AdminLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ad_username;
    private EditText ad_password;
    private Button btn_ad_in;
    StunNmberOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);
        initView();
    }

    private void initView() {
        ad_username = (EditText) findViewById(R.id.number);
        ad_password = (EditText) findViewById(R.id.name);
        btn_ad_in = (Button) findViewById(R.id.btn_in);


        btn_ad_in.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_in:
                if(submit()){
                    return;
                }else {
                    if(isLogin()){
                        Intent intent=new Intent(this, AdminManagementActivity.class);
                        startActivity(intent);
                    }
                }
                break;
        }
    }

    private boolean submit()
    {
        // validate
        if (true) {
            String username = ad_username.getText().toString().trim();
            if (TextUtils.isEmpty(username)) {
                Toast.makeText(this, "请输入管理员账号", Toast.LENGTH_SHORT).show();
                return true;
            }
            String password = ad_password.getText().toString().trim();
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "请输入管理员密码", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }

    //废弃
    private boolean isLogin_feiqi(){
        helper=new StunNmberOpenHelper(this);
        Map<String,String> map;
        map=helper.admin_query();
        if(ad_password.getText().toString().equals(map.get(ad_username.getText().toString()))){
            Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
            return true;
        }else{
            Toast.makeText(this,"登录失败",Toast.LENGTH_LONG).show();
            return false;
        }
    }
    private boolean isLogin(){
        if(ad_username.getText().toString().equals("admin")&&ad_password.getText().toString().equals("admin")){
            Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
            return true;
        }else{
            Toast.makeText(this,"登录失败",Toast.LENGTH_LONG).show();
            return false;
        }
    }

}

