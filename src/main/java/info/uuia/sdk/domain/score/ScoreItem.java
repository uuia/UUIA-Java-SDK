package info.uuia.sdk.domain.score;

import info.uuia.sdk.domain.ExtraDataItem;

import java.util.ArrayList;

/**
 * @author UUIA
 */
public class ScoreItem {
    private String name;
    private String courseCode;
    private String credit;
    private String grade;
    private ArrayList<ExtraDataItem> extraData;

    public ScoreItem(String name, String courseCode, String credit, String grade) {
        this.name = name;
        this.courseCode = courseCode;
        this.credit = credit;
        this.grade = grade;
    }

    public ScoreItem() {
        extraData = new ArrayList<ExtraDataItem>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public ArrayList<ExtraDataItem> getExtraData() {
        return extraData;
    }

    public void addItem(String key, String value) {
        extraData.add(new ExtraDataItem(key, value));
    }
}
