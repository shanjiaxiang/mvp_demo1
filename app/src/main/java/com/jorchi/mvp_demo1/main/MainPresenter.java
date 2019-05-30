package com.jorchi.mvp_demo1.main;

import java.util.List;

public class MainPresenter {
    private MainInteractor mainInteractor;
    private MainView mainView;

    public MainPresenter(MainInteractor mainInteractor, MainView mainView) {
        this.mainInteractor = mainInteractor;
        this.mainView = mainView;
    }

    public void setItems(){
        mainView.showProgress();
        mainInteractor.getItems(this::onFinished);
    }


    void onFinished(List<String> items){
        mainView.setItems(items);
        mainView.hideProgress();
    }

    void onItemClicked(int position){
        mainView.showMessage(position+"");
    }

}
