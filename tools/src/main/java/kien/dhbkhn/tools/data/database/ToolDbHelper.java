package kien.dhbkhn.tools.data.database;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by KienDepTrai on 12/02/2018.
 */

public class ToolDbHelper<D extends SugarRecord> implements IToolDbHelper<D> {

    public ToolDbHelper(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void insertItem(D data) {
        data.save();
    }

    @Override
    public void insertListItem(List<D> listData) {
        SugarRecord.saveInTx(listData);
    }

    @Override
    public List<D> findAllItem(Class<D> dClass) {
        return D.find(dClass, null, null);
    }

    @Override
    public List<D> findItemByQuery(Class<D> dClass, String property, String... values) {
        return D.find(dClass, property, values);
    }

    @Override
    public List<D> findItemByQueryLimit(Class<D> dClass, int limit, String property,
                                                                String... values) {
        return D.find(dClass, property, values, null, null, String.valueOf(limit));
    }

    @Override
    public D findItemById(Class<D> dClass, int id) {
        return D.findById(dClass, id);
    }

    @Override
    public void updateItemUnique(D data) {
        data.update();
    }

    @Override
    public void deleteItem(D data) {
        if (data != null) data.delete();
    }

    @Override
    public void deleteItemById(Class<D> dClass, int id) {
        D data = D.findById(dClass, id);
        if (data != null) data.delete();
    }

    @Override
    public void deleteItemByQuery(Class<D> dClass, String property, String... values) {
        List<D> listData = D.find(dClass, property, values);
        if(listData != null && !listData.isEmpty())
            SugarRecord.deleteInTx(listData);
    }
}
