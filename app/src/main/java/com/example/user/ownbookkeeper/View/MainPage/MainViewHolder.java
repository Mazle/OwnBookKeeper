package com.example.user.ownbookkeeper.View.MainPage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;;
import com.example.user.ownbookkeeper.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 09.04.2018.
 */

public class MainViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.title_of_card)
    TextView mcardTitle;

    public MainViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setTitle(String cardTitle) {
        this.mcardTitle.setText(cardTitle);
    }
}
