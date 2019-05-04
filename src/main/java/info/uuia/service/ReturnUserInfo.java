package info.uuia.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.domain.userinfo.UserInfo;
import info.uuia.repository.GetUserInfo;
import info.uuia.util.LackNecessaryInfoException;
import info.uuia.util.NotImplementedException;
import info.uuia.util.UUIALogger;

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
            UUIALogger.e(getClass().getName(), "没有实现方法");
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
