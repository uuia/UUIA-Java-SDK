package info.uuia.sdk.domain.schedule;

import java.util.ArrayList;

/**
 * @author UUIA
 */
public class ScheduleItem {
    private String name;
    private String code;
    private ArrayList<String> teachers;
    private ArrayList<DetailItem> schedules;

    public ScheduleItem(String courseName, String courseCode, ArrayList<String> teachers, ArrayList<DetailItem> courseSchedules) {
        this.name = courseName;
        this.code = courseCode;
        this.teachers = teachers;
        this.schedules = courseSchedules;
    }

    public ScheduleItem() {
        teachers = new ArrayList<>();
        schedules = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<String> getTeachers() {
        return teachers;
    }

    public void addTeacher(String teacher) {
        teachers.add(teacher);
    }

    public ArrayList<DetailItem> getSchedules() {
        return schedules;
    }

    public  void addSchedule(DetailItem schedule) {
        schedules.add(schedule);
    }
}
