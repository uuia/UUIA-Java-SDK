package info.uuia.sdk.domain.campuscard;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import info.uuia.sdk.domain.ExtraDataItem;
import info.uuia.sdk.domain.ResponseData;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * @author UUIA
 */
public class CampusCard implements ResponseData {

    @NotNull
    private String uuid;

    private String studentID;
    private String name;
    private String balance;
    private ArrayList<ExtraDataItem> extraData;

    public CampusCard(String uuid, String studentID, String name, String balance) {
        this.uuid = uuid;
        this.studentID = studentID;
        this.name = name;
        this.balance = balance;
        this.extraData = new ArrayList<ExtraDataItem>();
    }

    public CampusCard(String uuid, String studentID, String name, String balance, JSONArray extraData) {
        this.uuid = uuid;
        this.studentID = studentID;
        this.name = name;
        this.balance = balance;
        this.extraData = (ArrayList<ExtraDataItem>) JSON.parseArray(extraData.toJSONString(), ExtraDataItem.class);
    }

    public CampusCard(String uuid, String studentID, String name, String balance, ArrayList<ExtraDataItem> extraData) {
        this.uuid = uuid;
        this.studentID = studentID;
        this.name = name;
        this.balance = balance;
        this.extraData = extraData;
    }


    public void setUuid(String uuid){
        this.uuid = uuid;
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

    public ArrayList<ExtraDataItem> getExtraData() {
        return extraData;
    }

    public void addItem(String key, String value) {
        extraData.add(new ExtraDataItem(key, value));
    }
}
