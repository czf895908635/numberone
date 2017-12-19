package com.example.myapplication_nihao;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.myapplication_nihao.adapter.RecyclerAdapter;
import com.example.myapplication_nihao.base.BaseActivity;
import com.example.myapplication_nihao.bean.student;
import com.example.myapplication_nihao.contract.Contract;
import com.example.myapplication_nihao.contract.Model;
import com.example.myapplication_nihao.contract.Presenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 齐天大圣 on 2017/12/18.
 */
public class MainActivityOne extends BaseActivity<Presenter, Model> implements Contract.View {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<student.InfoListBean> infoList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activityone_main;
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerAdapter = new RecyclerAdapter(MainActivityOne.this,infoList);
        mPresenter.getDataFromModel("http://172.16.35.55:8080/6666/data.json");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivityOne.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter.setListener(new RecyclerAdapter.onClick() {
            @Override
            public void setItem(View v, int possiton) {
                Intent intent = new Intent(MainActivityOne.this,MainActivityThree.class);
                intent.putExtra("123",infoList.get(possiton).getImg());
                intent.putExtra("456",infoList.get(possiton).getGoods_name());
                intent.putExtra("789",infoList.get(possiton).getIntegral());
                startActivity(intent);

            }
        });

    }


    @Override
    public void show(final String ss) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                student student = gson.fromJson(ss, student.class);
                Log.e("sss--------",ss);
                infoList.addAll(student.getInfoList());
                recyclerView.setAdapter(recyclerAdapter);
                //recyclerAdapter.notify();
            }
        });
    }
}
