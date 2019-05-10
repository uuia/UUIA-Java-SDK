package info.uuia.sdk.domain.campuscard;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import info.uuia.sdk.domain.ExtraDataItem;
import info.uuia.sdk.domain.ResponseData;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class CampusCard implements ResponseData {

    @NotNull
    private String uuid;

    private String studentID;
    private String name;
    private String balance;
    private JSONArray extraData;

    public CampusCard(String studentID, String name, String balance, ArrayList<ExtraDataItem> extraData) {
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
