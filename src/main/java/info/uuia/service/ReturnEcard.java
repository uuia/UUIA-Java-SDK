package info.uuia.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.domain.ecard.Ecard;
import info.uuia.repository.GetEcard;
import info.uuia.util.LackNecessaryInfoException;

public class ReturnEcard {
    Ecard getResponse(JSONObject request) {
        Ecard response = new GetEcard().getData((String) request.get("uuid"));
        try {
            if (check(response)) {
                return response;
            }
        } catch (LackNecessaryInfoException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(Ecard data) throws LackNecessaryInfoException {
        if (data.getUuid()==null) {
            throw new LackNecessaryInfoException("Need String uuid as a property of userinfo.");
        } else if (data.getName()==null) {
            throw new LackNecessaryInfoException("Need String name as a property of userinfo.");
        } else if (data.getBalance()==null) {
            throw new LackNecessaryInfoException("Need String balance as a property of userinfo.");
        }
        return true;
    }
}
