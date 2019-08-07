package info.uuia.sdk.domain;


public class ExtraDataItem  {
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
