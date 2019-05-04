package info.uuia.repository;


import info.uuia.util.NotImplementedException;

public interface DataRepository<T> {
    T getData(String uuid) throws NotImplementedException;
}
