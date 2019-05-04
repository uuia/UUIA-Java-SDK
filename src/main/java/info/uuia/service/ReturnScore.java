package info.uuia.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.domain.score.Score;
import info.uuia.repository.GetScore;
import info.uuia.util.LackNecessaryInfoException;
import info.uuia.util.NotImplementedException;
import info.uuia.util.UUIALogger;

public class ReturnScore {
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
            UUIALogger.e(getClass().getName(), "没有实现方法");
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
