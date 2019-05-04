package info.uuia.util;

import java.util.Date;

public class UUIALogger {
    public static void i(String tag, String content) {
        System.out.println(new Date().toString() + ": INFO [" + tag + "]" + content);
    }

    public static void e(String tag, String content) {
        System.out.println(new Date().toString() + ": ERROR [" + tag + "]" + content);
    }
}
