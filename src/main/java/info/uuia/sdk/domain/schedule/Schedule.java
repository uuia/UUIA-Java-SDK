package info.uuia.sdk.domain.schedule;


import info.uuia.sdk.domain.ResponseData;

import java.util.ArrayList;

/**
 * @author UUIA
 */
public class Schedule implements ResponseData {

    private String uuid;

    private ArrayList<ScheduleItem> courses;

    public Schedule(String uuid, ArrayList<ScheduleItem> courses) {
        this.uuid = uuid;
        this.courses = courses;
    }

    public String getUuid() {
        return uuid;
    }

    public ArrayList<ScheduleItem> getCourses() {
        return courses;
    }
}
