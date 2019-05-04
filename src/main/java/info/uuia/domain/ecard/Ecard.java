package info.uuia.domain.ecard;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import info.uuia.domain.ExtraDataItem;
import info.uuia.domain.Response;

import java.util.ArrayList;

public class Ecard implements Response {
    private String uuid;
    private String studentID;
    private String name;
    private String balance;
    private JSONArray extraData;

    public Ecard(String studentID, String name, String balance, ArrayList<ExtraDataItem> extraData) {
        this.studentID = studentID;
        this.name = name;
        this.balance = balance;
        this.extraData = new JSONArray();
        this.extraData = JSONArray.parseArray(JSON.toJSONString(extraData));
    }

    public String getUuid() {
        return uuid;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getBalance() {
        return balance;
    }

    public JSONArray getExtraData() {
        return extraData;
    }
}
