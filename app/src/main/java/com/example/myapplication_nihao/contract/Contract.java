package com.example.myapplication_nihao.contract;


import com.example.myapplication_nihao.base.BaseModel;
import com.example.myapplication_nihao.base.BasePresenter;
import com.example.myapplication_nihao.base.BaseView;

public class Contract {

    public interface View extends BaseView {
      void show(String ss);
    }

    interface Model extends BaseModel {
        void getDataFromNer(String url, CallBacks callBacks);

    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        @Override
        public void onStart() {

        }
        public abstract void getDataFromModel(String url);
        
    }
}