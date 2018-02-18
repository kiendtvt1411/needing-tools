package kien.dhbkhn.tools.data.download;

import android.view.View;

import kien.dhbkhn.tools.list.BaseViewHolder;
import kien.dhbkhn.tools.list.OnRecyclerObjectClickListener;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public abstract class DefaultViewHolder<F extends DefaultDownload>
        extends BaseViewHolder<F, OnRecyclerObjectClickListener<F>> {

    public DefaultViewHolder(View itemView) {
        super(itemView);
    }
}
