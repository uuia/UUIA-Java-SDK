package info.uuia.sdk.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Semester {
    public static final String DEFAULT_SEMESTER_ID = "30";
    public static final String DEFAULT_SCHOOL_YEAR = "2018-2019";
    public static final String DEFAULT_SEMESTER = "3";

    private static JSONObject semesterMap;

    /*
     * 初始化学期信息
     * */
    public static void init() {
        File semester = new File("semester.json");
        Long fileLength = semester.length();
        byte[] fileContent = new byte[fileLength.intValue()];
        try {
            FileInputStream in = new FileInputStream(semester);
            in.read(fileContent);
            in.close();
            semesterMap = JSON.parseObject(new String(fileContent, StandardCharsets.UTF_8));
            System.out.println(semesterMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * @param id String 学期代码
     * @return String 学年 如2019-2020
     * */
    public static String getSchoolYearById(String id) {
        return semesterMap.getJSONObject(id).getString("schoolYear");
    }

    /*
     * @param id String 学期代码
     * @param String 学期 “1” 代表秋季学期 “2”代表春季学期 “3”代表夏季学期
     * */
    public static String getSemesterById(String id) {
        return semesterMap.getJSONObject(id).getString("semester");
    }
}