package info.uuia.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.domain.schedule.Schedule;
import info.uuia.repository.GetSchedule;
import info.uuia.util.LackNecessaryInfoException;
import info.uuia.util.NotImplementedException;
import info.uuia.util.UUIALogger;

public class ReturnSchedule {
    Schedule getResponse(JSONObject request) {
        try {
            Schedule response = new GetSchedule().getData((String) request.get("uuid"));
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

    private boolean check(Schedule data) throws LackNecessaryInfoException {
        if (data.getUuid()==null) {
            throw new LackNecessaryInfoException("Need String uuid as a property of " + data.getClass().getName());
        } else if (data.getCourses()==null) {
            throw new LackNecessaryInfoException("Need Array courses as a property of " + data.getClass().getName());
        }
        return true;
    }
}
