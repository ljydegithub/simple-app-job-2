package org.xyafu.app.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.xyafu.app.R;
import org.xyafu.app.fragment.PageImage;
import org.xyafu.app.fragment.PageMusic;
import org.xyafu.app.fragment.Page_Me;

public class PageActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView image,music,me;
    private FragmentManager manager;
    private FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_layout);
        initView();
        image.setImageResource(R.drawable.image_select);
        manager = getSupportFragmentManager();
        ft = manager.beginTransaction();
        PageImage fg = new PageImage();
        ft.replace(R.id.fragment, fg);
        ft.commit();
    }

    private void initView() {
        image =  findViewById(R.id.image);
        music = findViewById(R.id.music);
        me = findViewById(R.id.me);

        image.setOnClickListener(this);
        music.setOnClickListener(this);
        me.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.music:
                setBackground();
                music.setImageResource(R.drawable.music_select);
                ft = manager.beginTransaction();
                PageMusic fg02 = new PageMusic();
                ft.replace(R.id.fragment, fg02);
                ft.commit();
                break;
            case R.id.image:
                setBackground();
                image.setImageResource(R.drawable.image_select);
                ft = manager.beginTransaction();
                PageImage fg03 = new PageImage();
                ft.replace(R.id.fragment, fg03);
                ft.commit();
                break;
            case R.id.me:
                setBackground();
                me.setImageResource(R.drawable.person_select);
                ft = manager.beginTransaction();
                Page_Me fg04 = new Page_Me();
                chuanzhi();
                ft.commit();
                break;
        }
    }

    private void setBackground() {
        music.setImageResource(R.drawable.music);
        image.setImageResource(R.drawable.image);
        me.setImageResource(R.drawable.person);
    }

    public void chuanzhi() {
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putString("stu_name", intent.getStringExtra("stu_name"));
        bundle.putString("stu_number", intent.getStringExtra("stu_number"));
        Page_Me fragment = new Page_Me();
        fragment.setArguments(bundle);
        ft.add(R.id.fragment, fragment);
    }
}
