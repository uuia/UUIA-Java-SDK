package info.uuia.sdk.domain.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;

public class ScheduleItem {
    private String courseName;
    private String courseCode;
    private String[] teachers;
    private JSONArray courseSchedules;

    public ScheduleItem(String courseName, String courseCode, String[] teachers, ArrayList<DetailItem> courseSchedules) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.teachers = teachers;
        this.courseSchedules = JSONArray.parseArray(JSON.toJSONString(courseSchedules));
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String[] getTeachers() {
        return teachers;
    }

    public JSONArray getCourseSchedules() {
        return courseSchedules;
    }
}
