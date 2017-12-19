package com.example.myapplication_nihao.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication_nihao.utils.TUtils;


public abstract class BaseFrament<P extends BasePresenter,M extends BaseModel> extends Fragment {
    public P mPresenter;
    public M mModel;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(getLayoutId(),container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = TUtils.getT(this,0);
        mModel = TUtils.getT(this,1);

        if (this instanceof BaseView ) {
            mPresenter.setVM(mModel,this);
        }
        initView(view);
        initDate();
    }
    protected abstract void initDate();
    protected abstract void initView(View view);
    public abstract int getLayoutId();

}
