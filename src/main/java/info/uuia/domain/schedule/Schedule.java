package info.uuia.domain.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;

public class Schedule {
    private String uuid;
    private JSONArray courses;

    public Schedule(String uuid, ArrayList<ScheduleItem> courses) {
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
