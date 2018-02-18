package kien.dhbkhn.tools.ui;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by KienDepTrai on 11/02/2018.
 */

public abstract class BaseFragment extends Fragment implements IBaseFragment {

    /**
     * Initiate fragment by following steps:
     * <br> Setup: refer view with id by butter knife bind this view, and setup toolbar, list if need
     * <br> GetData: get data from singleton manager app
     * <br> UpdateUI: update view after have data
     */
    @Override
    public void initFragment(View view) {
        setup(view);
        getData();
        updateUI();
    }

    /**
     * Don't forget to release data if need in method releaseData()
     */
    @Override
    public void onDetach() {
        releaseData();
        super.onDetach();
    }
}
