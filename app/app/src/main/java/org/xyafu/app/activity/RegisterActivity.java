package org.xyafu.app.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.xyafu.app.R;
import org.xyafu.app.dao.StunNmberOpenHelper;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener  {
    private EditText number;
    private EditText name;
    private Button btn_in;
    StunNmberOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        number = (EditText) findViewById(R.id.number);
        name = (EditText) findViewById(R.id.name);
        btn_in = (Button) findViewById(R.id.btn_in);

        btn_in.setOnClickListener(RegisterActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_in:
                if(submit()){
                    return;
                }else {
                    re();
                }
                break;
        }
    }

    private boolean submit() {
        if(true) {
            // validate
            String username = number.getText().toString().trim();
            if (TextUtils.isEmpty(username)) {
                Toast.makeText(this, "请输入学号", Toast.LENGTH_SHORT).show();
                return true;
            }

            String password = name.getText().toString().trim();
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "请输入你的姓名", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
        // TODO validate success, do something

    }

    public void re(){
        helper=new StunNmberOpenHelper(this);
        helper.insert(number.getText().toString(),name.getText().toString());
        Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
        finish();
    }
}
