package info.uuia.sdk.domain.bindtype;

/**
 * @author UUIA
 */
public class BindTypeItem {
    private String comment;
    private String code;
    private String ref;
    private boolean isSkip;

    public BindTypeItem(String comment, String code, String ref, boolean isSkip) {
        this.comment = comment;
        this.code = code;
        this.ref = ref;
        this.isSkip = isSkip;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public boolean getIsSkip() {
        return isSkip;
    }

    public void setIsSkip(boolean isSkip) {
        this.isSkip = isSkip;
    }
}
