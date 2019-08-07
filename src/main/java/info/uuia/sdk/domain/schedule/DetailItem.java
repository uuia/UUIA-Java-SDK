package info.uuia.sdk.domain.schedule;

import java.util.ArrayList;

/**
 * @author UUIA
 */
public class DetailItem {
    private ArrayList<Integer> weeks;
    private Integer day;
    private ArrayList<Integer> sections;
    private String classroom;

    public DetailItem(ArrayList<Integer> weeks, int day, ArrayList<Integer> sections, String classroom) {
        this.weeks = weeks;
        this.day = day;
        this.sections = sections;
        this.classroom = classroom;
    }

    public DetailItem() {}

    public ArrayList<Integer> getWeeks() {
        return weeks;
    }

    public void setWeeks(ArrayList<Integer> weeks) {
        this.weeks = weeks;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int days) {
        this.day = days;
    }

    public ArrayList<Integer> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Integer> sections) {
        this.sections = sections;
    }

    public String getClassroom() {
        return classroom;
    }

    public void  setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
