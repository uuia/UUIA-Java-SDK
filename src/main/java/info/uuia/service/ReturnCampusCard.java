package info.uuia.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.domain.campuscard.CampusCard;
import info.uuia.repository.GetCampusCard;
import info.uuia.util.LackNecessaryInfoException;
import info.uuia.util.NotImplementedException;
import info.uuia.util.UUIALogger;

public class ReturnCampusCard {
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
            UUIALogger.e(getClass().getName(), "没有实现方法");
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
