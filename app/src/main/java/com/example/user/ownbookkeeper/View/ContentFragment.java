package com.example.user.ownbookkeeper.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.ownbookkeeper.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by user on 19.04.2018.
 * layoutManager назначать из активити, перед добавлением во fragmentManager
 * по умолчанию устанавливается LinearLayoutManager с горизонтальной ориентацией.
 */

public class ContentFragment<T> extends Fragment {
    private Unbinder unbinder;
    private ArrayList<T> dataList;
    @BindView(R.id.contentHorizontalRecycler)
    RecyclerView contentFragmentRecycler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       initializeLayoutManager();

    }

     @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment,container,false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setFragmentLayoutManager(RecyclerView.LayoutManager layoutManager) {
        contentFragmentRecycler.setLayoutManager(layoutManager);
    }

    private void initializeLayoutManager() {
        LinearLayoutManager linearLM = new LinearLayoutManager(getActivity());
        linearLM.setOrientation(LinearLayoutManager.HORIZONTAL);
        contentFragmentRecycler.setLayoutManager(linearLM);
    }
}

