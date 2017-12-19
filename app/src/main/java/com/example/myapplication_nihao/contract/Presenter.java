package com.example.myapplication_nihao.contract;


public class Presenter extends Contract.Presenter{

    @Override
    public void getDataFromModel(String url) {
        baseModel.getDataFromNer(url, new CallBacks() {
            @Override
            public void succ(String result) {
                baseView.show(result);
            }
        });
    }
}