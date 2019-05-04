package info.uuia.domain;

import com.alibaba.fastjson.JSONObject;

public class ExtraDataItem extends JSONObject {
    private String key;
    private String value;

    public ExtraDataItem(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
