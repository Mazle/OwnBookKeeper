package com.example.user.ownbookkeeper.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.ownbookkeeper.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by user on 24.04.2018.
 *
 */

public class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    PublishSubject<Integer> mSubj;
    @BindView(R.id.title_of_content_card)
    TextView cardTitle;
    @BindView(R.id.value_of_content_card)
    TextView cardValue;
    private Observable<Integer> itemListObservable;

    public ContentViewHolder(View itemView, PublishSubject<Integer> mSubj) {
        super(itemView);
        this.mSubj = mSubj;
        itemView.setOnClickListener(this);
        ButterKnife.bind(this, itemView);
        itemListObservable = Observable.create(new ObservableOnSubscribe<Integer>(){
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(getAdapterPosition());
            }
        });
    }

    public void setTextForCardTitle(String title) {
        this.cardTitle.setText(title);
    }

    public void setTextForCardValue(String value) {
        this.cardValue.setText(value);
    }

    @Override
    public void onClick(View view) {
        itemListObservable.subscribe(mSubj);
    }
}
