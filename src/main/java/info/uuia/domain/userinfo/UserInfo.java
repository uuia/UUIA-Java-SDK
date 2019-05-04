package info.uuia.domain.userinfo;

import com.alibaba.fastjson.JSONObject;
import info.uuia.domain.Response;

public class UserInfo extends JSONObject implements Response {
    private String uuid;
    private String name;
    private String gender;
    private String college;
    private String major;
    private String grade;
    private String studentClass;
    private String studentID;
    private String studentType;

    public UserInfo(String uuid, String name, String gender, String college, String major, String grade, String studentClass, String studentID, String studentType) {
        this.uuid = uuid;
        this.name = name;
        this.gender = gender;
        this.college = college;
        this.major = major;
        this.grade = grade;
        this.studentClass = studentClass;
        this.studentID = studentID;
        this.studentType = studentType;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCollege() {
        return college;
    }

    public String getMajor() {
        return major;
    }

    public String getGrade() {
        return grade;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentType() {
        return studentType;
    }
}
