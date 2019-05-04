package info.uuia.domain.score;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;

public class Score {
    private String uuid;
    private String gpa;
    private JSONArray courses;

    public Score(String uuid, String gpa, ArrayList<ScoreItem> courses) {
        this.uuid = uuid;
        this.gpa = gpa;
        this.courses = JSONArray.parseArray(JSON.toJSONString(courses));
    }

    public String getUuid() {
        return uuid;
    }

    public String getGpa() {
        return gpa;
    }

    public JSONArray getCourses() {
        return courses;
    }
}
