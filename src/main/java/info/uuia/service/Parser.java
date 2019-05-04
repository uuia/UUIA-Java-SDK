package info.uuia.service;

import com.alibaba.fastjson.JSONObject;

public class Parser {
    public Object parse(JSONObject request) {
        String group = request.getString("group");

        if ("base".equals(group)){
            return handleForBase(request);
        } else {

        }
        return null;
    }

    private Object handleForBase(JSONObject request) {
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
                return new ReturnEcard().getResponse(request);
            default:
                break;
        }

        return null;
    }
}
