package info.uuia.sdk.repository;


import info.uuia.sdk.domain.ResponseData;
import info.uuia.sdk.exception.NotImplementedException;

/**
 * 可返回的自定义数据源
 *
 * @param <T> 数据源返回类型
 */
public interface DataRepository<T extends ResponseData> {
    T getData(String uuid) throws NotImplementedException;
}
