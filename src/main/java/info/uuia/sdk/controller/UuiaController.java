package info.uuia.sdk.controller;

import com.alibaba.fastjson.JSONObject;
import info.uuia.sdk.service.Parser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UuiaController {
    @RequestMapping(value = "/uuia", method = {RequestMethod.POST})
    public JSONObject mainEntry(@RequestBody JSONObject request) {
        // UUIA 对外接口路由
        return (JSONObject) new Parser().parse(request);
    }
}
