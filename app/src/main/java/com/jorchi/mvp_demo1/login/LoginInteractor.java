package com.jorchi.mvp_demo1.login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginInteractor {
    interface LoginResultListener {
        void onNameError();

        void onPwdError();

        void onSuccess();
    }

    public void verifyLogin(String name, String pwd, LoginResultListener listener) {
        // x秒后返回结果
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(name)) {
                    listener.onNameError();
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    listener.onPwdError();
                    return;
                }
                listener.onSuccess();
            }
        },1000);
    }
}
