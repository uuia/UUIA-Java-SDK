package info.uuia.sdk.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.sdk.domain.ResponseData;
import info.uuia.sdk.exception.LackNecessaryInfoException;
import info.uuia.sdk.exception.NotImplementedException;
import info.uuia.sdk.repository.DataRepository;
import info.uuia.sdk.util.UuiaLogger;

import java.lang.reflect.InvocationTargetException;

abstract class ReturnData<T extends ResponseData> {
    T getResponse(JSONObject request) {
        try {
            T response = produce().getData((String) request.get("uuid"));
            check(response);
            return response;
        } catch (LackNecessaryInfoException e) {
            e.printStackTrace();
        } catch (NotImplementedException e) {
            e.printStackTrace();
            UuiaLogger.e(getClass().getName(), "没有实现方法");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            UuiaLogger.e(getClass().getName(), "没有正确的构造方法");
        } catch (InstantiationException e) {
            e.printStackTrace();
            UuiaLogger.e(getClass().getName(), "无法实例化数据仓库类");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            UuiaLogger.e(getClass().getName(), "构造方法可见性必须为public");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            UuiaLogger.e(getClass().getName(), "InvocationTargetException");
        }
        return null;
    }

    abstract void check(T data) throws LackNecessaryInfoException;

    abstract DataRepository<T> produce() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
