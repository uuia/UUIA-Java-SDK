package info.uuia.sdk.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.sdk.domain.userinfo.UserInfo;
import info.uuia.sdk.repository.GetUserInfo;
import info.uuia.sdk.util.LackNecessaryInfoException;
import info.uuia.sdk.util.NotImplementedException;
import info.uuia.sdk.util.UuiaLogger;

class ReturnUserInfo {
    UserInfo getResponse(JSONObject request) {
        try {
            UserInfo response = new GetUserInfo().getData((String) request.get("uuid"));
            if (check(response)) {
                return response;
            }
        } catch (LackNecessaryInfoException e) {
            e.printStackTrace();
        } catch (NotImplementedException e) {
            e.printStackTrace();
            UuiaLogger.e(getClass().getName(), "没有实现方法");
        }
        return null;
    }

     private boolean check(UserInfo data) throws LackNecessaryInfoException {
        if (data.getUuid()==null) {
            throw new LackNecessaryInfoException("Need String uuid as a property of userinfo.");
        } else if (data.getName()==null) {
            throw new LackNecessaryInfoException("Need String name as a property of userinfo.");
        }
        return true;
    }
}
