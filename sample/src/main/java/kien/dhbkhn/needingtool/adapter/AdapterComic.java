package kien.dhbkhn.needingtool.adapter;

import android.content.Context;
import android.view.ViewGroup;

import kien.dhbkhn.needingtool.R;
import kien.dhbkhn.needingtool.server.Datum;
import kien.dhbkhn.tools.list.GenericsRecyclerAdapter;
import kien.dhbkhn.tools.list.OnRecyclerObjectClickListener;

/**
 * Created by KienDepTrai on 17/02/2018.
 */

public class AdapterComic extends GenericsRecyclerAdapter<Datum, OnRecyclerObjectClickListener<Datum>,
        ViewHolderComic> {
    /**
     * Base constructor
     * Allocate adapter-related objects here if needed
     *
     * @param context Context needed to retrieve LayoutInflater
     */
    public AdapterComic(Context context) {
        super(context);
    }

    @Override
    public ViewHolderComic onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderComic(inflate(R.layout.item_comic, parent));
    }
}
