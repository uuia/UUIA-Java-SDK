package info.uuia.sdk.util;

import com.alibaba.fastjson.JSONObject;
import info.uuia.sdk.constant.Constant;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Validator {
    public boolean validate(JSONObject request) {
        String signature = request.getString("signature");
        String timestamp = request.getString("timestamp");
        String nonce = request.getString("nonce");
        UuiaLogger.i("uuia校验接口", signature + "," + timestamp + "," + nonce);

        String[] strings = new String[]{Constant.appToken, timestamp, nonce};
        StringBuilder builder = new StringBuilder();
        Arrays.sort(strings);
        for (String string : strings) {
            builder.append(string);
        }

        String res = sha1(builder.toString());
        if (signature.equalsIgnoreCase(res)) {
            UuiaLogger.i("成功！", "Success");
            return true;
        }

        UuiaLogger.i("失败", "Fail");
        return false;
    }

    private String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = digest.digest(str.getBytes());
            return toHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

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
