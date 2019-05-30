package com.jorchi.mvp_demo1.login;

public class LoginPresenter implements LoginInteractor.LoginResultListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void verifyLogin(String name, String pwd) {
        loginView.showProgress();
        loginInteractor.verifyLogin(name, pwd, this);
    }

    @Override
    public void onNameError() {
        loginView.hideProgress();
        loginView.nameError();
    }

    @Override
    public void onPwdError() {
        loginView.hideProgress();
        loginView.pwdError();
    }

    @Override
    public void onSuccess() {
        loginView.hideProgress();
        loginView.toMainPage();
    }
}
