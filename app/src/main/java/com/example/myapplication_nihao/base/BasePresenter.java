package com.example.myapplication_nihao.base;


public abstract  class BasePresenter<M, V> {
    public M baseModel;
    public V baseView;
    public void setVM(M m,V v){
        baseModel=m;
        baseView=v;
        this.onStart();
    }

    public abstract void onStart();
    
}
