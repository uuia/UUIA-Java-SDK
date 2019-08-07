package info.uuia.sdk.domain.exam;

import info.uuia.sdk.domain.ResponseData;

import java.util.ArrayList;

/**
 * @author UUIA
 */
public class Exam implements ResponseData {
    private String uuid;
    private ArrayList<ExamItem> courses;

    public Exam( ArrayList<ExamItem> courses) {
        this.courses = courses;
    }

    public Exam(String uuid, ArrayList<ExamItem> courses) {
        this.uuid = uuid;
        this.courses = courses;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public ArrayList<ExamItem> getCourses() {
        return courses;
    }
}
