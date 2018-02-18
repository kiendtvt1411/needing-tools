package kien.dhbkhn.tools.list;

/**
 * Created by KienDepTrai on 21/01/2018.
 */

public interface OnRecyclerObjectClickListener<T> extends BaseRecyclerListener {

    /**
     * Item has been clicked
     *
     * @param item object associated with the clicked item
     */
    void onItemClicked(T item);
}
