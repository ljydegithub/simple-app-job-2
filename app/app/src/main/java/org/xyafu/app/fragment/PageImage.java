package org.xyafu.app.fragment;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import org.xyafu.app.MainActivity;
import org.xyafu.app.R;
import org.xyafu.app.activity.PageActivity;

import java.util.ArrayList;
import java.util.List;


public class PageImage extends Fragment {

    private  int[]  arrayPicture=null;
    private ImageSwitcher imageSwitcher;
    private int  index;
    private  float touchDownX;
    private  float touchUpX;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_image, null);
        imageSwitcher=view.findViewById(R.id.image_switch);
        initImage();
        //设置视图工厂
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView  imageView=new ImageView(view.getContext());
                imageView.setImageResource(arrayPicture[index]);//设置显示图片（利用下标）
                return imageView;//返回图像视图
            }
        });
        //设置触摸监听器
        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //判断动作是不是按下  获得按下时的X坐标
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    touchDownX=event.getX();
                    return true;
                } else if(event.getAction()==MotionEvent.ACTION_UP) {
                    touchUpX=event.getX();
                    //判断是左滑动还是右滑动
                    if(touchUpX-touchDownX>100){
                        //判断是不是第一张图片 是就将索引变成最后一张图片索引，
                        // 不是则当前索引减一
                        index=index==0?arrayPicture.length-1:index-1;
                        //使用自带的淡入淡出
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(view.getContext(),android.R.anim.fade_in));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(view.getContext(),android.R.anim.fade_out));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    }else if(touchDownX-touchUpX>100){
                        index=index==arrayPicture.length-1?0:index+1;//注意这里下标是从0开始的，所以应该是长度减1
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(view.getContext(),android.R.anim.fade_in));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(view.getContext(),android.R.anim.fade_out));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    }
                    return true;
                }
                return false;
            }
        });
        return view;
    }


    private void initImage(){
        arrayPicture=new int[] {
                R.drawable.img01,
                R.drawable.img03,
                R.drawable.img04,
                R.drawable.img05,
                R.drawable.img07,
                R.drawable.img08,
                R.drawable.img09,
                R.drawable.img10,
                R.drawable.img11,
                R.drawable.img12,
                R.drawable.img13
        };
    }

}
