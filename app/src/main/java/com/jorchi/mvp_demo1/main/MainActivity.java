package com.jorchi.mvp_demo1.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jorchi.mvp_demo1.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private RecyclerView mListView;
    private ProgressBar mProgressBar;
    private MainPresenter mainPresenter;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.list_view);
        mProgressBar = findViewById(R.id.progress_bar);
        mainPresenter = new MainPresenter(new MainInteractor(), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.setItems();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setItems(List<String> items) {
        mainAdapter = new MainAdapter(items, mainPresenter:: onItemClicked);
        mListView.setAdapter(mainAdapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mListView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mListView.setVisibility(View.VISIBLE);
    }
}



















