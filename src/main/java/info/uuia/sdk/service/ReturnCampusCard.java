package info.uuia.sdk.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.sdk.domain.campuscard.CampusCard;
import info.uuia.sdk.repository.GetCampusCard;
import info.uuia.sdk.util.LackNecessaryInfoException;
import info.uuia.sdk.util.NotImplementedException;
import info.uuia.sdk.util.UuiaLogger;

class ReturnCampusCard {
    CampusCard getResponse(JSONObject request) {
        try {
            CampusCard response = new GetCampusCard().getData((String) request.get("uuid"));
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

    private boolean check(CampusCard data) throws LackNecessaryInfoException {
        if (data.getUuid()==null) {
            throw new LackNecessaryInfoException("Need String uuid as a property of " + data.getClass().getName());
        } else if (data.getName()==null) {
            throw new LackNecessaryInfoException("Need String name as a property of " + data.getClass().getName());
        } else if (data.getBalance()==null) {
            throw new LackNecessaryInfoException("Need String balance as a property of " + data.getClass().getName());
        }
        return true;
    }
}
