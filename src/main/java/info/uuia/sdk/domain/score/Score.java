package info.uuia.sdk.domain.score;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import info.uuia.sdk.domain.ResponseData;

import java.util.ArrayList;

/**
 * @author UUIA
 */
public class Score implements ResponseData {
    private String uuid;
    private String gpa;
    private ArrayList<ScoreItem> courses;

    public Score( ArrayList<ScoreItem> courses) {
        this.courses = courses;
    }

    public Score(String uuid,String gpa, ArrayList<ScoreItem> courses) {
        this.uuid = uuid;
        this.gpa = gpa;
        this.courses = courses;
    }

    public Score(String uuid, String gpa, JSONArray courses) {
        this.uuid = uuid;
        this.gpa = gpa;
        this.courses = (ArrayList<ScoreItem>) JSON.parseArray(courses.toJSONString(), ScoreItem.class);
    }
	
	public Score(String gpa, ArrayList<ScoreItem> courses) {
        this.gpa = gpa;
        this.courses = courses;
    }
	
    public String getUuid() {
        return uuid;
    }

    public String getGpa() {
        return gpa;
    }

    public ArrayList<ScoreItem> getCourses() {
        return courses;
    }
}
