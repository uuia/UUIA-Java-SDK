package info.uuia.sdk.util;

import com.alibaba.fastjson.JSONObject;
import info.uuia.sdk.Config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Validator {

	/*
	*@param JSONobject request HTTP请求内容
	*@return Boolean 是否验证通过
	*/	
    public boolean validate(JSONObject request) {

        String signature = request.getString("signature");
        String timestamp = request.getString("timestamp");
        UuiaLogger.i("UUIA Validator", "sig=" + signature + ",timestamp=" + timestamp);

        String res = sha256(sha256(Config.UUIA_APP_ID + Config.UUIA_APP_SECRET) + timestamp);
        if (signature.equalsIgnoreCase(res)) {
            UuiaLogger.i("UUIA Validator", "Success");
            return true;
        }

        UuiaLogger.i("UUIA Validator", "Fail");
        return false;
    }

    /*
    * Desctiption: sha256散列
	* @param String str 要散列的字符串
	* @return String 散列的结果HEX格式
    */	
    private String sha256(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(str.getBytes());
            return toHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*
	* Description 将byte转化为HEX字符串
	* @param byte[] 要转化的数据
	* @return String 转化的HEX字符串
    */
    private String toHex(byte[] bytes) {
        StringBuilder str = new StringBuilder();
        for (byte b : bytes) {
            char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] temp = new char[2];
            temp[0] = chars[(b >>> 4) & 0x0F];
            temp[1] = chars[b & 0x0F];

            str.append(new String(temp));
        }
        return str.toString();
    }
}
