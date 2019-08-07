package info.uuia.sdk.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import info.uuia.sdk.controller.UuiaController;
import info.uuia.sdk.dao.CredentialDao;
import info.uuia.sdk.dao.StudentDao;
import info.uuia.sdk.dao.UserDao;
import info.uuia.sdk.dao.entity.CredentialDo;
import info.uuia.sdk.dao.entity.UserDo;
import info.uuia.sdk.domain.bind.Bind;
import info.uuia.sdk.domain.bindtype.BindType;
import info.uuia.sdk.domain.userinfo.UserInfo;
import info.uuia.sdk.util.Semester;
import info.uuia.sdk.util.UuiaLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class Base implements Group {

    // JPA数据库DAO
    private UserDao userDao;
    private CredentialDao credentialDao;


    public Base(UuiaController uuiaController) {
        userDao = uuiaController.getUserDao();
        credentialDao = uuiaController.getCredentialDao();
    }


    /*
    * @Description: 储存用户凭据
    *
    * @param String uuid 用户的UUID
    * @param String username 用户的用户名，指用户在该服务下的账号，一般是学号
    * @param String password 用户密码
    * @param int 服务ID
    * */
    private void storageCredential(String uuid, String username, String password, int code) {

        CredentialDo credentialDo = new CredentialDo();
        credentialDo.setPassword(password);
        credentialDo.setStudentId(username);
        credentialDo.setUuid(uuid);
        credentialDo.setCode(code);
        credentialDao.save(credentialDo);

    }

    /*
    * Description: base group 的处理服务
    *
    * @param JSONObject request 发来的HTTP请求转化为JSON格式
    * @return JSONObject response返回的data字段的内容
    * */
    @Override
    public JSONObject getResponse(JSONObject request) {
		
		// 验证服务器信息
		String signature = request.getString("signature");
        String timestamp = request.getString("timestamp");

        if(signature == null) {
            JSONObject data = new JSONObject();
            data.put("msg","need signature");
            return data;
        } else if(timestamp == null) {
            JSONObject data = new JSONObject();
            data.put("msg","need timestamp");
            return data;
        } else if(!new Validator().validate(timestamp, signature)) {
            JSONObject data = new JSONObject();
            data.put("msg","valid fail");
            return data;
        }

        // 初始化可能需要的数据
        String action = request.getString("action");
        String uuid = request.getString("uuid");
        JSONObject data = request.getJSONObject("data");
        if(data == null) {
            data = new JSONObject();
        }
        // TODO: 其他可能需要初始化的内容

        switch (action) {
            // 绑定账号的类型
            case "bindType":
                BindType accountTypes = new BindType();
                // TODO: 添加需要绑定的账号
				
                return (JSONObject) JSONObject.toJSON(accountTypes);

            // 绑定账号
            case "bind":

                try {
                    JSONObject account = request.getJSONObject("data").getJSONObject("account");
                    int code = Integer.parseInt(account.getString("code"));
                    switch (code) {
                        case 1:
                            // TODO: code为1的情况
                        case  2:
                            // TODO: code为2的情况（可选）
                        
                    }
                } catch (NullPointerException e) {
                    UuiaLogger.e("BIND", "A request without data at "+System.currentTimeMillis());
                    return (JSONObject) JSONObject.toJSON(new Bind(false,uuid));
                }

            // 获取用户信息
            case "userInfo":
                // TODO: 获取、保存用户信息的逻辑请于此实现
            // 获取课表
            case "courseTable":
                // TODO: 获取课表的逻辑请于此实现
            // 获取成绩
            case "score":
                // TODO: 获取成绩的逻辑请于此实现
            // 获取考试日程
            case "exam":
                // TODO: 获取考试的逻辑请于此实现
            // 获取一卡通信息
            case "campusCard":
                // TODO: 获取一卡通信息的逻辑请于此实现
        }
        return new JSONObject();
    }

}
