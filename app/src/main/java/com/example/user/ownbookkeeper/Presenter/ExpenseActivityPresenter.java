package com.example.user.ownbookkeeper.Presenter;

import android.util.Log;

import com.example.user.ownbookkeeper.Model.DAO.DriverDao;
import com.example.user.ownbookkeeper.Model.DataModel.CashSource;
import com.example.user.ownbookkeeper.Model.DataModel.Decreasable;
import com.example.user.ownbookkeeper.Model.DataModel.Usage;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by user on 25.04.2018.
 * Возможно, нужно было создать презентер активити, содержащий два презентера фрагментов одного
 * класса, чтобы не придумывать дполнительные методы к имеющемуся абстрактному презентеру.
 */

public class ExpenseActivityPresenter extends ContentRecyclerCardPresenter<Decreasable> {
    //дополнительный clickObserver для второго фрагмента activity.
    Observer<Integer> usagesClickObserver;
    ArrayList<Usage> usagesList;
    boolean decreasableSelection;
    boolean usagesSelection;

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
        usagesList = DriverDao.getCategoryUsageList();
    }

    @Override
    protected void createClickObserver() {
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

    @Override
    protected void createDataList() {
        dataList = DriverDao.getDecreasableList();
    }

    public ArrayList<Usage> getUsagesList() {
        return usagesList;
    }

    public Observer<Integer> getUsagesClickObserver() {
        return usagesClickObserver;
    }
}
