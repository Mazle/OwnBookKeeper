package com.example.user.ownbookkeeper.Presenter;


import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by user on 24.04.2018.
 * TODO: сделать заполнение datalist в конструкторе
 */

public class ContentRecyclerCardPresenter<T> {
    protected Observer<Integer> clickObserver;
    ArrayList<T> dataList;

    public ContentRecyclerCardPresenter() {
        this.clickObserver = new Observer<Integer>(){
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    public Observer<Integer> getClickObserver() {
        return clickObserver;
    }

    public ArrayList<T> getDataList() {
        return dataList;
    }
}
