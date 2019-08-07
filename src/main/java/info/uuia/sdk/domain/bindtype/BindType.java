package info.uuia.sdk.domain.bindtype;

import info.uuia.sdk.domain.ResponseData;

import java.util.ArrayList;

/**
 * @author UUIA
 */
public class BindType implements ResponseData {
    private ArrayList<BindTypeItem> accountTypes;

    public BindType(ArrayList<BindTypeItem> accountTypes) {
        this.accountTypes = accountTypes;
    }

    public BindType() {
        this.accountTypes = new ArrayList<BindTypeItem>();
    }

    public void addItem(String comment, String code, String ref, boolean isSkip) {
        accountTypes.add(new BindTypeItem(comment, code, ref, isSkip));
    }

    public ArrayList<BindTypeItem> getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(ArrayList<BindTypeItem> accountTypes) {
        this.accountTypes = accountTypes;
    }
}
