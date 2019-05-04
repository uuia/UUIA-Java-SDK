package info.uuia.domain.score;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import info.uuia.domain.ExtraDataItem;

public class ScoreItem extends JSONObject {
    private String name;
    private String courseCode;
    private String credit;
    private String grade;
    private JSONArray extraData;

    ScoreItem(String name, String courseCode, String credit, String grade) {
        this.name = name;
        this.courseCode = courseCode;
        this.credit = credit;
        this.grade = grade;
        this.extraData = new JSONArray();
    }

    public String getName() {
        return name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCredit() {
        return credit;
    }

    public String getGrade() {
        return grade;
    }

    public JSONArray getExtraData() {
        return extraData;
    }

    public void addItem(String key, String value) {
        extraData.add(new ExtraDataItem(key, value));
    }
}
