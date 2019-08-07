package info.uuia.sdk.domain.userinfo;

import info.uuia.sdk.domain.ResponseData;

/**
 * @author UUIA
 */
public class UserInfo implements ResponseData {
    private String uuid;
    private String name;
    private String gender;
    private String college;
    private String major;
    private String grade;
    private String studentClass;
    private String studentID;
    private String studentType;

    public UserInfo(String uuid,String name, String gender, String college, String major, String grade, String studentClass, String studentID, String studentType) {
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

    public UserInfo(String uuid,String name, String gender, String college, String major, String grade, String studentClass, String studentID) {
        this.uuid = uuid;
        this.name = name;
        this.gender = gender;
        this.college = college;
        this.major = major;
        this.grade = grade;
        this.studentClass = studentClass;
        this.studentID = studentID;
    }

    public UserInfo(String uuid,String name, String gender, String college, String major, String grade, String studentClass) {
        this.uuid = uuid;
        this.name = name;
        this.gender = gender;
        this.college = college;
        this.major = major;
        this.grade = grade;
        this.studentClass = studentClass;
    }

    public UserInfo(String uuid,String name, String gender, String college, String major, String grade) {
        this.uuid = uuid;
        this.name = name;
        this.gender = gender;
        this.college = college;
        this.major = major;
        this.grade = grade;
    }

    public UserInfo(String uuid,String name, String gender, String college, String major) {
        this.uuid = uuid;
        this.name = name;
        this.gender = gender;
        this.college = college;
        this.major = major;
    }

    public UserInfo(String uuid,String name, String gender, String college) {
        this.uuid = uuid;
        this.name = name;
        this.gender = gender;
        this.college = college;
    }

    public UserInfo(String uuid,String name, String gender) {
        this.uuid = uuid;
        this.name = name;
        this.gender = gender;
    }

    public UserInfo(String uuid,String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
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
