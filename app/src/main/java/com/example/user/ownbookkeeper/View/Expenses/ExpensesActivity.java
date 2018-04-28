package com.example.user.ownbookkeeper.View.Expenses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.example.user.ownbookkeeper.Presenter.ExpenseActivityPresenter;
import com.example.user.ownbookkeeper.R;
import com.example.user.ownbookkeeper.View.ContentFragment;

import butterknife.BindView;

/**
 * Created by user on 16.04.2018.
 */

public class ExpensesActivity extends AppCompatActivity {
   //TODO: написать метод сохранения состояния презентера при перевороте экрана.
    public ExpenseActivityPresenter presenter;
    private FragmentManager fm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expences_activity);
        fm = getSupportFragmentManager();
        createPresenter();
        createAndBindFragments();
    }

    private void createAndBindFragments() {
        ContentFragment<ExpenseActivityPresenter> decresableFragment = new DecreasableFragmentInExpensesActivity();
        decresableFragment.setPresenter(this.presenter);
        UsagesFragmentInExpensesActivity usagesFragment = new UsagesFragmentInExpensesActivity();
        GridLayoutManager gLM = new GridLayoutManager(this, 3);
        usagesFragment.setFragmentLayoutManager(gLM);
        usagesFragment.setPresenter(this.presenter);
        fm.beginTransaction()
                .add(R.id.decreasable_expense_container,decresableFragment)
                .add(R.id.usages_expense_container,usagesFragment)
                .commit();

    }

    private void createPresenter() {
        this.presenter = new ExpenseActivityPresenter();
    }
}
