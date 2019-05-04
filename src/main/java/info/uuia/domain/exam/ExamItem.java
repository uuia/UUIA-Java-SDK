package info.uuia.domain.exam;

import com.alibaba.fastjson.JSONArray;
import info.uuia.domain.ExtraDataItem;

public class ExamItem {
    private String name;
    private String courseCode;
    private String time;
    private String place;
    private JSONArray extraData;

    ExamItem(String name, String courseCode, String time, String place) {
        this.name = name;
        this.courseCode = courseCode;
        this.time = time;
        this.place = place;
        this.extraData = new JSONArray();
    }

    public String getName() {
        return name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public JSONArray getExtraData() {
        return extraData;
    }

    public void addItem(String key, String value) {
        extraData.add(new ExtraDataItem(key, value));
    }
}
