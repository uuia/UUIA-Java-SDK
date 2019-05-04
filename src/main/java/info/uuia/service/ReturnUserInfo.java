package info.uuia.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.domain.userinfo.UserInfo;
import info.uuia.repository.GetUserInfo;
import info.uuia.util.LackNecessaryInfoException;

class ReturnUserInfo {
    UserInfo getResponse(JSONObject request) {
        UserInfo response = new GetUserInfo().getData((String) request.get("uuid"));
        try {
            if (check(response)) {
                return response;
            }
        } catch (LackNecessaryInfoException e) {
            e.printStackTrace();
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
