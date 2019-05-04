package info.uuia.domain.exam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import info.uuia.domain.ResponseData;

import java.util.ArrayList;

public class Exam implements ResponseData {
    private String uuid;
    private JSONArray courses;

    public Exam(String uuid, String gpa, ArrayList<ExamItem> courses) {
        this.uuid = uuid;
        this.courses = JSONArray.parseArray(JSON.toJSONString(courses));
    }

    public String getUuid() {
        return uuid;
    }

    public JSONArray getCourses() {
        return courses;
    }
}
