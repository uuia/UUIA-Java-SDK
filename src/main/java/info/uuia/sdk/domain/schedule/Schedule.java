package info.uuia.sdk.domain.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import info.uuia.sdk.domain.ResponseData;

import java.util.ArrayList;

public class Schedule implements ResponseData {
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
