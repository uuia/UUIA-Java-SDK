package info.uuia.controller;

import com.alibaba.fastjson.JSONObject;
import info.uuia.service.Parser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UuiaController {

    @RequestMapping(value = "/uuia", method = {RequestMethod.POST})
    public JSONObject uuia(@RequestBody JSONObject request) {
        return (JSONObject) new Parser().parse(request);
    }
}
