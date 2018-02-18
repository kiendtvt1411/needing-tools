package kien.dhbkhn.tools.data.database;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by KienDepTrai on 12/02/2018.
 */

public interface IToolDbHelper<D extends SugarRecord> {

    void insertItem(D data);

    void insertListItem(List<D> listData);

    List<D> findAllItem(Class<D> dClass);

    List<D> findItemByQuery(Class<D> dClass, String property, String... values);

    List<D> findItemByQueryLimit(Class<D> dClass, int limit, String property, String... values);

    D findItemById(Class<D> dClass, int id);

    void updateItemUnique(D data);

    void deleteItem(D data);

    void deleteItemById(Class<D> dClass, int id);

    void deleteItemByQuery(Class<D> dClass, String property, String... values);
}
