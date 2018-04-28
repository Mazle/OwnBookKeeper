package com.example.user.ownbookkeeper.View.Expenses;

import com.example.user.ownbookkeeper.Presenter.ExpenseActivityPresenter;
import com.example.user.ownbookkeeper.View.ContentRVAdapter;
import com.example.user.ownbookkeeper.View.ContentViewHolder;

/**
 * Created by user on 26.04.2018.
 */

public class DecreasableRVAdapter extends ContentRVAdapter<ExpenseActivityPresenter> {
    public DecreasableRVAdapter(ExpenseActivityPresenter presenter) {
        super(presenter);
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
       holder.setTextForCardTitle(presenter.getDataList().get(position).getName());
       holder.setTextForCardValue(Long.toString(presenter.getDataList().get(position).getCashAmount()));
    }
}
