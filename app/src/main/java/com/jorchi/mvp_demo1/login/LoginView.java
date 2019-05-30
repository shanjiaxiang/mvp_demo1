package com.jorchi.mvp_demo1.login;

public interface LoginView {
    void showProgress();

    void hideProgress();

    void nameError();

    void pwdError();

    void toMainPage();
}
