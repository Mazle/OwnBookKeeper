package com.example.user.ownbookkeeper.View.MainPage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.ownbookkeeper.Presenter.MainFunctionsFragmentPresenter;
import com.example.user.ownbookkeeper.R;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * Created by user on 09.04.2018.
 */

public class MainRVAdapter extends RecyclerView.Adapter<MainViewHolder> {

    MainFunctionsFragmentPresenter presenter;
    PublishSubject<Integer> itemClickSubject;

    public MainRVAdapter(MainFunctionsFragmentPresenter presenter) {
        this.presenter = presenter;
        itemClickSubject = PublishSubject.create();
        itemClickSubject.subscribe(presenter.getClickObserver());
     }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_activity_card,parent,false);
        return new MainViewHolder(itemView, itemClickSubject);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.setTitle(presenter.getItemsList().get(position).getmItemName());
    }

    @Override
    public int getItemCount() {
        return presenter.getItemsList().size();
    }

}
