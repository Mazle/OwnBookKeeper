package com.example.user.ownbookkeeper.View.MainPage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.ownbookkeeper.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by user on 06.04.2018.
 */

public class MainListViewFragment extends Fragment{
    private Unbinder unbinder;
    @BindView(R.id.rv_for_main_fragment)
    RecyclerView rvMain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_list_fragment, container, false);
        unbinder = ButterKnife.bind(this, v);
        rvMain.setAdapter(new MainRVAdapter(getActivity()));
        rvMain.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
