package info.uuia.sdk.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;
/*
* Description: UUIA服务的基础接口
* */
@Repository
public interface Group {
    public JSONObject getResponse(JSONObject request);
}
