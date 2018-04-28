package com.example.user.ownbookkeeper.View;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.ownbookkeeper.Presenter.ContentRecyclerCardPresenter;
import com.example.user.ownbookkeeper.R;

import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by user on 24.04.2018.
 * Заполнение holder сделать в унаследованных классах
 */

public abstract class ContentRVAdapter<P extends ContentRecyclerCardPresenter> extends RecyclerView.Adapter<ContentViewHolder> {
    //для отправки номера кликнутого itemView в presenter
    protected PublishSubject<Integer> itemClickSubject;
    protected P presenter;
    protected Observer<Integer> clickObserver;

    public ContentRVAdapter(P presenter) {
        this.presenter = presenter;
        setObserverForAdapter();
        this.itemClickSubject = PublishSubject.create();
        itemClickSubject.subscribe(clickObserver);
    }

    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_recycler_card,parent,false);
        return new ContentViewHolder(itemView, itemClickSubject);
    }

    @Override
    public abstract void onBindViewHolder(ContentViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return presenter.getDataList().size();
    }

    //переопределять метод, если источник observer'а отличается от стандартного
    protected void setObserverForAdapter() {
        clickObserver = presenter.getClickObserver();
    }
}
