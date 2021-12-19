package org.xyafu.app.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.xyafu.app.R;
import org.xyafu.app.dao.StunNmberOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminManagementActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView studentList;
    StunNmberOpenHelper helper;
    List<String> list;
    private EditText studentId;
    private EditText studentName;
    private EditText studentNumber;
    private Button btn_delete;
    private Button btn_update,btn_insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_management);
        initView();
        query();
    }

    private void initView() {
        studentList = (ListView) findViewById(R.id.student_list);
        studentId = (EditText) findViewById(R.id.student_id);
        studentId.setOnClickListener(this);
        studentName = (EditText) findViewById(R.id.student_name);
        studentName.setOnClickListener(this);
        studentNumber = (EditText) findViewById(R.id.student_number);
        studentNumber.setOnClickListener(this);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(this);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);
        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_insert.setOnClickListener(this);
    }

    public void query() {
        helper = new StunNmberOpenHelper(this);
        list = helper.listQuery();
        String[] id = new String[list.size() / 3];
        String[] name = new String[list.size() / 3];
        String[] number = new String[list.size() / 3];
        int j = 0, k = 1, l = 2, p1, p2, p3;
        p1 = p2 = p3 = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == j) {
                id[p1] = list.get(i);
                p1++;
                j += 3;
            } else if (i == k) {
                name[p2] = list.get(i);
                p2++;
                k += 3;
            } else if (i == l) {
                number[p3] = list.get(i);
                p3++;
                l += 3;
            }
        }
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("_id", id[i]);
            map.put("name", name[i]);
            map.put("number", number[i]);
            data.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.students_list_layout
                , new String[]{"_id", "name", "number"}, new int[]{R.id.list_id, R.id.list_name, R.id.list_number});
        studentList.setAdapter(simpleAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_delete:
                String id = studentId.getText().toString().trim();
                if (TextUtils.isEmpty(id)) {
                    Toast.makeText(this, "ID不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    if(helper.delete(studentId.getText().toString())){
                        Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "删除失败", Toast.LENGTH_SHORT).show();
                    }
                    query();
                }

                break;
            case R.id.btn_update:
                if (submit(0)){
                    if(helper.update(studentId.getText().toString(),studentName.getText().toString(),studentNumber.getText().toString())){
                        Toast.makeText(this, "更改成功", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "更改失败", Toast.LENGTH_SHORT).show();
                    }
                    query();
                }
                break;
            case R.id.btn_insert:
                if (submit(1)){
                    if(helper.insert(studentNumber.getText().toString(),studentName.getText().toString())){
                        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
                    }
                    query();
                }
                break;
        }
    }

    private boolean submit(int i) {
        // validate
        if(true) {
            if(i==0){
                String id = studentId.getText().toString().trim();
                if (TextUtils.isEmpty(id)) {
                    Toast.makeText(this, "ID不能为空", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
            String name = studentName.getText().toString().trim();
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show();
                return false;
            }

            String number = studentNumber.getText().toString().trim();
            if (TextUtils.isEmpty(number)) {
                Toast.makeText(this, "学号不能为空", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
        // TODO validate success, do something
    }
}
