package kien.dhbkhn.needingtool;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import kien.dhbkhn.needingtool.adapter.AdapterComic;
import kien.dhbkhn.needingtool.server.ComicsByType;
import kien.dhbkhn.needingtool.server.Datum;
import kien.dhbkhn.tools.callback.CallbackDataRetrofit;
import kien.dhbkhn.tools.custom.KienRecyclerView;
import kien.dhbkhn.tools.ui.BaseActivity;

public class MainActivity extends BaseActivity {

//    @BindView(R.id.rv_sample)
    private KienRecyclerView mRvSample;

    private AppManager mManager;

    private List<Datum> mList;
    private AdapterComic mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActivity();
    }

    @Override
    public void setup() {
        ButterKnife.bind(this);
        mList = new ArrayList<>();
        mRvSample = findViewById(R.id.rv_sample);
        mAdapter = new AdapterComic(this);
        mRvSample.setAdapter(mAdapter);
        mAdapter.setItems(mList);
    }

    @Override
    public void getData() {
        mManager = AppManager.getInstance();
    }

    @Override
    public void updateUI() {
        mManager.getAllComicWithTypeId(5, 1000, new CallbackDataRetrofit<ComicsByType>() {
            @Override
            public void getData(ComicsByType data) {
                mList.clear();
                mList.addAll(data.getData());
                mAdapter.setItems(mList);
            }

            @Override
            public void notifyError(String message) {

            }
        });
    }

    @Override
    public void releaseData() {

    }

    @Override
    public void attachFragment(String tag) {

    }

    @Override
    public void detachFragment(String tag) {

    }
}
