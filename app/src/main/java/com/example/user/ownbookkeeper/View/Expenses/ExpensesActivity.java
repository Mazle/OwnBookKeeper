package com.example.user.ownbookkeeper.View.Expenses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.user.ownbookkeeper.Presenter.ExpensesActivityPresenter;
import com.example.user.ownbookkeeper.R;

/**
 * Created by user on 16.04.2018.
 */

public class ExpensesActivity extends AppCompatActivity {
   /*Запихнул презентер в статическое поле активити для того, чтобы иметь возможность
   * обращаться к нему из фрагментов активити, не прокидывая его через конструкторы*/
    static ExpensesActivityPresenter presenter;
    static {
        presenter = new ExpensesActivityPresenter();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expences_activity);

    }
}
