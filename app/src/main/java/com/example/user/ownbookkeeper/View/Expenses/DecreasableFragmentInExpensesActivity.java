package com.example.user.ownbookkeeper.View.Expenses;

import com.example.user.ownbookkeeper.Presenter.ExpenseActivityPresenter;
import com.example.user.ownbookkeeper.View.ContentFragment;

/**
 * Created by user on 26.04.2018.
 */

public class DecreasableFragmentInExpensesActivity extends ContentFragment <ExpenseActivityPresenter> {
    @Override
    protected void createAdapter() {
        this.adapter = new DecreasableRVAdapter(this.presenter);
    }
}
