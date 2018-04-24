package com.example.user.ownbookkeeper.View.MainPage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.ownbookkeeper.Presenter.MainFunctionsFragmentPresenter;
import com.example.user.ownbookkeeper.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment mainFragment = new MainListViewFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main_activity_frame,mainFragment);
        ft.commit();
    }

}
