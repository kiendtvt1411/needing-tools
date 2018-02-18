package kien.dhbkhn.needingtool.server;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by KienDepTrai on 17/02/2018.
 */

public interface ServiceComicInfo {

    @GET("{" + EndpointUtils.PATH_TO_GET_INFO_COMIC + "}")
    Observable<ComicsByType> createService(@Path(EndpointUtils.PATH_TO_GET_INFO_COMIC) String typeId,
                                                    @Query(EndpointUtils.QUERY_LIMIT_GET_INFO_COMIC) int limit);
}
