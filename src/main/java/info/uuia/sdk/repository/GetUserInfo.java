package info.uuia.sdk.repository;

import info.uuia.sdk.domain.userinfo.UserInfo;
import info.uuia.sdk.exception.NotImplementedException;

public class GetUserInfo implements DataRepository<UserInfo> {

    @Override
    public UserInfo getData(String uuid) throws NotImplementedException {
        // TODO: 在此实现你的数据获取逻辑 / Implement your data obtaining logic here
        throw new NotImplementedException("没有实现此数据获取逻辑");
    }
}
