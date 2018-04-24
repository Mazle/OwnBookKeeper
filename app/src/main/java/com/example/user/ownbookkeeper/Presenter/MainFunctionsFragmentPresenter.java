package com.example.user.ownbookkeeper.Presenter;

import android.content.Context;
import android.content.Intent;

import com.example.user.ownbookkeeper.R;
import com.example.user.ownbookkeeper.View.CashSource.CashSourceActivity;
import com.example.user.ownbookkeeper.View.Expenses.ExpensesActivity;
import com.example.user.ownbookkeeper.View.MainPage.MainActivity;
import com.example.user.ownbookkeeper.View.ShopList.ShopListActivity;
import com.example.user.ownbookkeeper.View.Targets.TargetsActivity;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by user on 16.04.2018.
 */

public class MainFunctionsFragmentPresenter {
    HashMap<Integer,ListItem> itemsList;
    Context mContext;
    Observer<Integer> clickObserver;

    public MainFunctionsFragmentPresenter(Context context) {
        mContext = context;
        initializeItemsList();
        clickObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Intent intent = new Intent(mContext,itemsList.get(integer).getCls());
                mContext.startActivity(intent);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    private void initializeItemsList() {
        this.itemsList = new HashMap<>();
        itemsList.put(0,new ListItem(
           mContext.getString(R.string.cash_source),
           CashSourceActivity.class
        ));
        itemsList.put(1,new ListItem(
                mContext.getString(R.string.expensives),
                ExpensesActivity.class
        ));
        itemsList.put(2,new ListItem(
                mContext.getString(R.string.targets),
                TargetsActivity.class
        ));
        itemsList.put(3,new ListItem(
                mContext.getString(R.string.shop_list),
                ShopListActivity.class
        ));
    }
    public HashMap<Integer, ListItem> getItemsList() {
        return itemsList;
    }
    public Observer<Integer> getClickObserver() {
        return clickObserver;
    }

    //Класс создан для ухода от конструкций if/else при определении реакций на клик item
    public class ListItem {
        String mItemName;
        Class<?> cls;

        public ListItem(String mItemName, Class<?> cls) {
            this.mItemName = mItemName;
            this.cls = cls;
        }

        public String getmItemName() {
            return mItemName;
        }

        public Class<?> getCls() {
            return cls;
        }
    }
}
