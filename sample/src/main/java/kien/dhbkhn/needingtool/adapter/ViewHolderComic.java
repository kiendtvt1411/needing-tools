package kien.dhbkhn.needingtool.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import kien.dhbkhn.needingtool.R;
import kien.dhbkhn.needingtool.server.Datum;
import kien.dhbkhn.tools.list.BaseViewHolder;
import kien.dhbkhn.tools.list.OnRecyclerObjectClickListener;

/**
 * Created by KienDepTrai on 17/02/2018.
 */

public class ViewHolderComic extends BaseViewHolder<Datum, OnRecyclerObjectClickListener<Datum>> {

//    @BindView(R.id.tv_sample)
    TextView mTvSample;

    public ViewHolderComic(View itemView) {
        super(itemView);
//        ButterKnife.bind(this, itemView);
        mTvSample = itemView.findViewById(R.id.tv_sample);
    }

    @Override
    public void onBind(Datum item, @Nullable OnRecyclerObjectClickListener<Datum> listener) {
        mTvSample.setText(item.getRank() + "/" + item.getName());
    }
}
