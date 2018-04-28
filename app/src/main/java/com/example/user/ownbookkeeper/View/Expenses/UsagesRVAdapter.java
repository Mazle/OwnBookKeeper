package com.example.user.ownbookkeeper.View.Expenses;

import android.util.Log;

import com.example.user.ownbookkeeper.Presenter.ContentRecyclerCardPresenter;
import com.example.user.ownbookkeeper.Presenter.ExpenseActivityPresenter;
import com.example.user.ownbookkeeper.View.ContentRVAdapter;
import com.example.user.ownbookkeeper.View.ContentViewHolder;

/**
 * Created by user on 26.04.2018.
 */

public class UsagesRVAdapter extends ContentRVAdapter<ExpenseActivityPresenter> {
    public UsagesRVAdapter(ExpenseActivityPresenter presenter) {
        super(presenter);
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        holder.setTextForCardTitle(presenter.getUsagesList().get(position).getName());
        //параиетр value не заполняется, так как для данного объекта не существует.
    }

    @Override
    protected void setObserverForAdapter() {
        Log.v("inAdapter",presenter.getUsagesClickObserver().toString());
        Log.v("inAdapter",presenter.toString());
        clickObserver = presenter.getUsagesClickObserver();
    }
}
