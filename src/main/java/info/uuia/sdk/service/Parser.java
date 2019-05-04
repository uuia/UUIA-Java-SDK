package info.uuia.sdk.service;

import com.alibaba.fastjson.JSONObject;
import info.uuia.sdk.domain.ResponseData;
import info.uuia.sdk.util.UuiaLogger;

/**
 * UUIA 请求解析器
 * 用于校验/解析符合UUIA规约的向子节点进行访问的请求
 * 校验后，向中心服务器返回请求的内容
 */
public class Parser {
    /**
     * 解析并返回中心服务器发出的请求
     * @param request 请求JSON内容
     * @return 解析后的UUIA结果。若为null，则表示出现错误。
     */
    public ResponseData parse(JSONObject request) {
        String group = request.getString("group");
        if ("base".equals(group)){
            return handleForBase(request);
        } else {
            UuiaLogger.i("UUIA Parser", "其它的非法请求。");
        }
        return null;
    }

    private ResponseData handleForBase(JSONObject request) {
        String action = request.getString("action");
        switch (action){
            case "bindType":

                break;
            case "bind":

                break;
            case "userInfo":
                return new ReturnUserInfo().getResponse(request);
            case "schedule":
                return new ReturnSchedule().getResponse(request);
            case "score":
                return new ReturnScore().getResponse(request);
            case "exam":
                return new ReturnExam().getResponse(request);
            case "eCard":
                return new ReturnCampusCard().getResponse(request);
            default:
                break;
        }

        return null;
    }
}
