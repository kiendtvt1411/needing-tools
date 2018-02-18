package kien.dhbkhn.tools.list;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by KienDepTrai on 21/01/2018.
 */

public abstract class BaseViewHolder<T, L extends BaseRecyclerListener> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Bind data to the item and set listener if needed
     * <br> if you want update view after change, you should set setIsRecyclable(false) (NOT RECOMMEND)
     *
     * @param item     object, associated with the item
     * @param listener listener a listener {@link BaseRecyclerListener}
     *                 which has to b set at the item (if not `null`)
     */
    public abstract void onBind(T item, @Nullable L listener);
}
