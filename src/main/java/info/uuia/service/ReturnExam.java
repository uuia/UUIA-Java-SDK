package info.uuia.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.domain.exam.Exam;
import info.uuia.repository.GetExam;
import info.uuia.util.LackNecessaryInfoException;

public class ReturnExam {
    Exam getResponse(JSONObject request) {
        Exam response = new GetExam().getData((String) request.get("uuid"));
        try {
            if (check(response)) {
                return response;
            }
        } catch (LackNecessaryInfoException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(Exam data) throws LackNecessaryInfoException {
        if (data.getUuid()==null) {
            throw new LackNecessaryInfoException("Need String uuid as a property of userinfo.");
        } else if (data.getCourses()==null) {
            throw new LackNecessaryInfoException("Need Array courses as a property of userinfo.");
        }
        return true;
    }
}
