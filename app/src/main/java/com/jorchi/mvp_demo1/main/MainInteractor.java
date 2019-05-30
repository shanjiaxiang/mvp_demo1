package com.jorchi.mvp_demo1.main;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class MainInteractor {

    interface OnFinishedListener{
        void onFinished(List<String> items);
    }

    public void getItems(OnFinishedListener listener){
        List<String> items = new ArrayList<>();
        items.add("item 1");
        items.add("item 2");
        items.add("item 3");
        items.add("item 4");
        items.add("item 5");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(items);
            }
        },1000);
    }
}
