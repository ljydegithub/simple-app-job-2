package org.xyafu.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.xyafu.app.R;
import org.xyafu.app.activity.LoginActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_in = (Button) findViewById(R.id.btn_in);

        btn_in.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_in:
                Intent intent=new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
