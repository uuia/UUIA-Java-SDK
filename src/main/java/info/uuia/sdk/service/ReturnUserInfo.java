package info.uuia.sdk.service;

import info.uuia.sdk.domain.userinfo.UserInfo;
import info.uuia.sdk.exception.LackNecessaryInfoException;
import info.uuia.sdk.factory.DataRepositoryFactory;
import info.uuia.sdk.repository.DataRepository;

import java.lang.reflect.InvocationTargetException;

class ReturnUserInfo extends ReturnData<UserInfo> {

    @Override
    void check(UserInfo data) throws LackNecessaryInfoException {
        if (data.getUuid() == null) {
            throw new LackNecessaryInfoException("Need String uuid as a property of userinfo.");
        } else if (data.getName() == null) {
            throw new LackNecessaryInfoException("Need String name as a property of userinfo.");
        }
    }

    @Override
    DataRepository<UserInfo> produce() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return DataRepositoryFactory.getUserInfoDataRepository();
    }
}
