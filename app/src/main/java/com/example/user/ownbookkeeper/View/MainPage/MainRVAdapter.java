package com.example.user.ownbookkeeper.View.MainPage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.ownbookkeeper.R;

import java.util.HashMap;

/**
 * Created by user on 09.04.2018.
 */

public class MainRVAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private HashMap<Integer, String> namesOfTitles;
    //для доступа к файлам ресурсов
    Context context;

    public MainRVAdapter(Context context) {
        this.context = context;
        initializeTitles();
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_activity_card,parent,false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.setTitle(namesOfTitles.get(position));
    }

    @Override
    public int getItemCount() {
        return namesOfTitles.size();
    }

    void initializeTitles() {
        this.namesOfTitles  = new HashMap<Integer, String>();
        namesOfTitles.put(0, context.getString(R.string.cash_source));
        namesOfTitles.put(1, context.getString(R.string.expensives));
        namesOfTitles.put(2, context.getString(R.string.targets));
        namesOfTitles.put(3, context.getString(R.string.shop_list));
    }
}
