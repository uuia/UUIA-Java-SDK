package info.uuia.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.domain.score.Score;
import info.uuia.repository.GetScore;
import info.uuia.util.LackNecessaryInfoException;

public class ReturnScore {
    Score getResponse(JSONObject request) {
        Score response = new GetScore().getData((String) request.get("uuid"));
        try {
            if (check(response)) {
                return response;
            }
        } catch (LackNecessaryInfoException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(Score data) throws LackNecessaryInfoException {
        if (data.getUuid()==null) {
            throw new LackNecessaryInfoException("Need String uuid as a property of userinfo.");
        } else if (data.getGpa()==null) {
            throw new LackNecessaryInfoException("Need String gpa as a property of userinfo.");
        } else if (data.getCourses()==null) {
            throw new LackNecessaryInfoException("Need Array courses as a property of userinfo.");
        }
        return true;
    }
}
