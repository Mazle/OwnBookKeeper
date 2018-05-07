package com.example.user.ownbookkeeper.Presenter;


import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by user on 24.04.2018.
 * В наследнике переопределить метод createDataList() для заполнения dataList
  */

public abstract class ContentRecyclerCardPresenter<T> {
    protected Observer<Integer> clickObserver;
    ArrayList<T> dataList;

    public ContentRecyclerCardPresenter() {
        createClickObserver();
        createDataList();
    }

    protected abstract void createClickObserver();

    protected abstract void createDataList();

    public Observer<Integer> getClickObserver() {
        return clickObserver;
    }

    public ArrayList<T> getDataList() {
        return dataList;
    }
}
