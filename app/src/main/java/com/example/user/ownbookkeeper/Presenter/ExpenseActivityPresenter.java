package com.example.user.ownbookkeeper.Presenter;

import android.util.Log;

import com.example.user.ownbookkeeper.Model.DataModel.CashSource;
import com.example.user.ownbookkeeper.Model.DataModel.Decreasable;
import com.example.user.ownbookkeeper.Model.DataModel.Usage;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by user on 25.04.2018.
 * TODO: написать методы для получения и обработки данных второго фрагмента
 */

public class ExpenseActivityPresenter extends ContentRecyclerCardPresenter<Decreasable> {
    Observer<Integer> usagesClickObserver;
    ArrayList<Usage> usagesList;

    public ExpenseActivityPresenter() {
        super();
        this.usagesClickObserver = new Observer<Integer>(){
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

    public ArrayList<Usage> getUsagesList() {
        return usagesList;
    }

    public Observer<Integer> getUsagesClickObserver() {
        return usagesClickObserver;
    }
}
