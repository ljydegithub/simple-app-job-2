package org.xyafu.app.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xyafu.app.R;
import org.xyafu.app.pojo.Music_mes;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Music_mes> data;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<Music_mes> data, Context context) {
        this.data = data;
        this.inflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
                View view = inflater.inflate(R.layout.music_list_demo,null);
        Music_mes music = (Music_mes) getItem(position);

        TextView tv_name = (TextView) view.findViewById(R.id.mu_name);
        TextView tv_per = (TextView) view.findViewById(R.id.mu_pre);
        ImageView musci_img=(ImageView)view.findViewById(R.id.music_img);

        //为Item 里面的组件设置相应的数据
        tv_name.setText(music.getMusic_name());
        tv_per.setText(music.getMusic_person());
        musci_img.setImageResource(music.getMusic_img());
        //返回含有数据的view
        return view;
    }

}
