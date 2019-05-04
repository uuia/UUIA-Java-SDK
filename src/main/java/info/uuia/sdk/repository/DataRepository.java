package info.uuia.sdk.repository;


import info.uuia.sdk.util.NotImplementedException;

/**
 * 可返回的自定义数据源
 * @param <T> 数据源返回类型
 */
public interface DataRepository<T> {
    T getData(String uuid) throws NotImplementedException;
}
