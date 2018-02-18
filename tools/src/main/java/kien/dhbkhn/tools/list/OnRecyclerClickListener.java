package kien.dhbkhn.tools.list;

/**
 * Created by KienDepTrai on 21/01/2018.
 */

public interface OnRecyclerClickListener extends BaseRecyclerListener {

    /**
     * RecyclerView item has been clicked
     *
     * @param id item id
     */
    void onItemClicked(long id);
}
