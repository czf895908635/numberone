package com.example.myapplication_nihao;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.myapplication_nihao.base.BaseActivity;
import com.example.myapplication_nihao.contract.Model;
import com.example.myapplication_nihao.contract.Presenter;

public class MainActivity extends BaseActivity<Presenter,Model> {
    private TextView textView;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Listener();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void Listener() {
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(MainActivity.this,MainActivityOne.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void initView() {
        textView = (TextView) findViewById(R.id.huanying);
        animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.set);
        textView.startAnimation(animation);
    }
}
