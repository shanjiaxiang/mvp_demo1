package com.jorchi.mvp_demo1.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jorchi.mvp_demo1.main.MainActivity;
import com.jorchi.mvp_demo1.R;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private EditText mName;
    private EditText mPwd;
    private Button mLogin;
    private ProgressBar mProgressBar;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mName = findViewById(R.id.username);
        mPwd = findViewById(R.id.pwd);
        mLogin = findViewById(R.id.login);
        mLogin.setOnClickListener(v -> {
            loginPresenter.verifyLogin(mName.getText().toString(), mPwd.getText().toString());
        });
        mProgressBar = findViewById(R.id.progress_bar);
        loginPresenter = new LoginPresenter(this, new LoginInteractor());
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void nameError() {
        mName.setError("name empty");
    }

    @Override
    public void pwdError() {
        mPwd.setError("pwd empty");
    }

    @Override
    public void toMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
