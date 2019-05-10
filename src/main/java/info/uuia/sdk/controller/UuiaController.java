package info.uuia.sdk.controller;

import com.alibaba.fastjson.JSONObject;
import info.uuia.sdk.constant.Constant;
import info.uuia.sdk.service.Parser;
import info.uuia.sdk.util.Validator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UuiaController {
    /* UUIA 对外接口路由 */
    @RequestMapping(value = "/uuia", method = {RequestMethod.POST})
    public JSONObject mainEntry(@RequestBody JSONObject request) {
        // 返回数据
        JSONObject data = new JSONObject();
        // 返回状态码
        String code;
        // 返回信息
        String msg;

        // 验证请求来自中央服务器
        if (!new Validator().validate(request)) {
            code = Constant.RESPONSE_CODE_UNAUTHORIZED;
            msg = Constant.RESPONSE_MSG_UNAUTHORIZED;
        } else {
            data = (JSONObject) new Parser().parse(request);
            code = Constant.RESPONSE_CODE_OK;
            msg = Constant.RESPONSE_MSG_OK;
        }

        return response(data, code, msg);
    }

    private JSONObject response(Object data, String code, String msg) {
        JSONObject result = new JSONObject();
        result.put("data", data);
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }
}
