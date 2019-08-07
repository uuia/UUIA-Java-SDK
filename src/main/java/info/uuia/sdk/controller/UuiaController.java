package info.uuia.sdk.controller;

import com.alibaba.fastjson.JSONObject;
import info.uuia.sdk.dao.CredentialDao;
import info.uuia.sdk.dao.UserDao;
import info.uuia.sdk.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController
public class UuiaController {

    // JPA 数据库DAO

    private UserDao userDao; // 用户信息

    private CredentialDao credentialDao; // 用户凭据

    // JPA setter

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setCredentialDao(CredentialDao credentialDao) {
        this.credentialDao = credentialDao;
    }

    // JPA getter

    public UserDao getUserDao() {
        return userDao;
    }

    public CredentialDao getCredentialDao() {
        return credentialDao;
    }


    // controller

    // ping测试服务是否启动
    @GetMapping(value = "ping")
    public JSONObject ping() {
        return getResponse(200,"pong", new JSONObject());
    }

    // UUIA服务控制器
    @PostMapping(value = "/uuia")
    public JSONObject mainController(@RequestBody JSONObject requestBody) {
        String group = requestBody.getString("group");


        if(group == null) {
            return getResponse(400, "No group", new JSONObject());
        }
        try {

            // 利用反射，得到对应group的service
            Class<?> uuiaGroupParser =
                    Class.forName("info.uuia.sdk.service."+group.substring(0,1).toUpperCase()+group.substring(1));
            Method getResponse = uuiaGroupParser.getMethod("getResponse", JSONObject.class);
            Constructor constructor = uuiaGroupParser.getConstructor(UuiaController.class);
            return getResponse(200, "OK", (JSONObject)getResponse.invoke(constructor.newInstance(this), requestBody));

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
            return getResponse(400, "No group", new JSONObject());// 没有找到对应的组

        } catch (NoSuchMethodException e) {

            e.printStackTrace();
            return getResponse(500, "Parser error", new JSONObject());// 没有response方法

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {

            e.printStackTrace();
            return getResponse(501, "error when getResponse", new JSONObject());

        }

    }

    // 生成response
    private JSONObject getResponse(int code, String message,JSONObject data) {

        JSONObject response = new JSONObject();

        response.put("code",code);
        response.put("data",data);
        response.put("message",message);

        return response;
    }

}
