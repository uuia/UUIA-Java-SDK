package info.uuia.sdk.util;

import java.util.Date;

public class UuiaLogger {
    public static void i(String tag, String content) {
        System.out.println(new Date().toString() + ": INFO [" + tag + "]" + content);
    }

    public static void e(String tag, String content) {
        System.out.println(new Date().toString() + ": ERROR [" + tag + "]" + content);
    }
}
