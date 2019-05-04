package info.uuia.sdk.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.sdk.domain.score.Score;
import info.uuia.sdk.repository.GetScore;
import info.uuia.sdk.exception.LackNecessaryInfoException;
import info.uuia.sdk.exception.NotImplementedException;
import info.uuia.sdk.util.UuiaLogger;

class ReturnScore {
    Score getResponse(JSONObject request) {
        try {
            Score response = new GetScore().getData((String) request.get("uuid"));
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

    private boolean check(Score data) throws LackNecessaryInfoException {
        if (data.getUuid()==null) {
            throw new LackNecessaryInfoException("Need String uuid as a property of " + data.getClass().getName());
        } else if (data.getGpa()==null) {
            throw new LackNecessaryInfoException("Need String gpa as a property of " + data.getClass().getName());
        } else if (data.getCourses()==null) {
            throw new LackNecessaryInfoException("Need Array courses as a property of " + data.getClass().getName());
        }
        return true;
    }
}
