package info.uuia.sdk.domain.exam;

import info.uuia.sdk.domain.ExtraDataItem;

import java.util.ArrayList;

/**
 * @author UUIA
 */
public class ExamItem {
    private String name;
    private String courseCode;
    private String time;
    private String place;
    private ArrayList<ExtraDataItem> extraData;

    public ExamItem(String name, String courseCode, String time, String place) {
        this.name = name;
        this.courseCode = courseCode;
        this.time = time;
        this.place = place;
        extraData = new ArrayList<>();
    }

    public ExamItem(String name, String courseCode, String time, String place, ArrayList<ExtraDataItem> extraData) {
        this.name = name;
        this.courseCode = courseCode;
        this.time = time;
        this.place = place;
        this.extraData = extraData;
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

    public ArrayList<ExtraDataItem> getExtraData() {
        return extraData;
    }

    public void addItem(String key, String value) {
        extraData.add(new ExtraDataItem(key, value));
    }
}
