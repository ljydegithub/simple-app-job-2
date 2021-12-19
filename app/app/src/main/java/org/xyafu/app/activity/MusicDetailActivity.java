package org.xyafu.app.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.xyafu.app.R;

public class MusicDetailActivity extends AppCompatActivity {
    private TextView music_name;
    private TextView music_pre;
    private TextView music;
    private MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_detailed);
        initView();
        Intent intent=getIntent();
        music_name.setText(intent.getStringExtra("name"));
        music_pre.setText(intent.getStringExtra("person"));
        music.setText(intent.getStringExtra("music"));
        int temp=intent.getIntExtra("music_s",0);
        mediaPlayer = MediaPlayer.create(this,temp);
        mediaPlayer.start();
    }


    private void initView() {
        music_name = (TextView) findViewById(R.id.music_name);
        music_pre = (TextView) findViewById(R.id.music_pre);
        music = (TextView) findViewById(R.id.music);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}
