package info.uuia.sdk.domain.bind;

import info.uuia.sdk.domain.ResponseData;

import javax.validation.constraints.NotNull;

/**
 * @author UUIA
 */
public class Bind implements ResponseData {
    @NotNull
    private boolean valid;

    private String uuid;

    private String errorMsg;

    public Bind(boolean ifSuccess, String uuid) {
        this.valid = ifSuccess;
        this.uuid = uuid;
    }

    public Bind(boolean ifSuccess, String uuid, String errorMsg) {
        this.valid = ifSuccess;
        this.uuid = uuid;
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public boolean getIfSuccess() {
        return valid;
    }

    public String getUuid() {
        return uuid;
    }

}
