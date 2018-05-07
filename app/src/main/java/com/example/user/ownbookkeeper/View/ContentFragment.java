package com.example.user.ownbookkeeper.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.ownbookkeeper.Presenter.ContentRecyclerCardPresenter;
import com.example.user.ownbookkeeper.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by user on 19.04.2018.
 * Общий класс фрагмента, который будет содержать в себе recycler для разных типов данных, в зависимости от запущенной активити.
 * layoutManager назначать из активити, перед добавлением во fragmentManager
 * по умолчанию устанавливается LinearLayoutManager с горизонтальной ориентацией.
 * TODO: написать проверку presenter на null
 */

public abstract class ContentFragment<P extends ContentRecyclerCardPresenter> extends Fragment {
    private Unbinder unbinder;
    protected P presenter;
    protected ContentRVAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @BindView(R.id.contentRecycler)
    RecyclerView contentFragmentRecycler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeLayoutManager();
        createAdapter();
    }
    //переопределить, если используется нестандартный адаптер
    //TODO решить, как менять адаптер, унаследовать класс фрагмента или поменять адаптер из активити
    protected abstract void createAdapter();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment,container,false);
        unbinder = ButterKnife.bind(this,view);
        contentFragmentRecycler.setAdapter(this.adapter);
        contentFragmentRecycler.setLayoutManager(this.layoutManager);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setFragmentLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    private void initializeLayoutManager() {
        if (this.layoutManager==null) {
            LinearLayoutManager linearLM = new LinearLayoutManager(getActivity());
            linearLM.setOrientation(LinearLayoutManager.HORIZONTAL);
            this.layoutManager = linearLM;
        }
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }
}

