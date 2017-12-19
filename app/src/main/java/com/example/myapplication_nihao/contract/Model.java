package com.example.myapplication_nihao.contract;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
* Created by TMVPHelper on 2017/11/20
*/
public class Model implements Contract.Model{
    private static Model model;
    private OkHttpClient client;
    public static  Model getInstance(){
        if (model == null) {
            synchronized (Model.class) {
                model = new Model();
            }
        }
        return model;

    }
    public Model(){
        client = new OkHttpClient();
    }


    @Override
    public void getDataFromNer(String url, final CallBacks callBacks) {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
                                            @Override
                                            public void onFailure(okhttp3.Call call, IOException e) {

                                            }

                                            @Override
                                            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                                                callBacks.succ(response.body().string());
                                            }
                                        }
        );
    }
}