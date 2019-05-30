package com.jorchi.mvp_demo1.main;

import java.util.List;

public interface MainView {
    void setItems(List<String> items);

    void showMessage(String message);

    void showProgress();

    void hideProgress();
}
