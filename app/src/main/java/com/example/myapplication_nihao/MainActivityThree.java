package com.example.myapplication_nihao;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication_nihao.base.BaseActivity;
import com.example.myapplication_nihao.contract.Model;
import com.example.myapplication_nihao.contract.Presenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * Created by 齐天大圣 on 2017/12/18.
 */
public class MainActivityThree extends BaseActivity<Presenter,Model> {
    private Banner banner;
    private TextView one;
    private TextView two;
    private ArrayList<String> arraylist = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activitythree_main;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("123");
        String stringExtra1 = intent.getStringExtra("456");
        String stringExtra2 = intent.getStringExtra("789");
        arraylist.add(stringExtra);
        arraylist.add(stringExtra);
        one= (TextView) findViewById(R.id.one);
        two= (TextView) findViewById(R.id.two);
        banner= (Banner) findViewById(R.id.BannerOne);
        banner.setImages(arraylist)//添加图片集合或图片url集合
                .setDelayTime(2000)//设置轮播时间
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setImageLoader(new GlideImage())//加载图片
                .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置
                .start();
        one.setText(stringExtra1);
        two.setText(stringExtra2);

    }
    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }
    }
}
