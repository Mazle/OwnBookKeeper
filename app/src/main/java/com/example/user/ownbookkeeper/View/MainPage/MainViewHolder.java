package com.example.user.ownbookkeeper.View.MainPage;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;;
import com.example.user.ownbookkeeper.R;

import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by user on 09.04.2018.
 */

public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.title_of_card)
    TextView mcardTitle;
    static int count = 0; /*создано для подсчета порядкового номера создаваемого холдера.*/
    private Observable<Integer> itemListObservable;
    private PublishSubject<Integer> mSubj;

    public MainViewHolder(View itemView, PublishSubject<Integer> subj) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
        mSubj = subj;
        itemListObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(getAdapterPosition());
            }
        });
        increaseCount();
        Log.v("VH","View Holder №"+count);
    }

    public static void increaseCount(){
        MainViewHolder.count++;
    } /*for testing*/

    public void setTitle(String cardTitle) {
        this.mcardTitle.setText(cardTitle);
    }

    @Override
    public void onClick(View view) {
        Log.v("cliked","item was clicked");
        itemListObservable.subscribe(mSubj);
    }
}
