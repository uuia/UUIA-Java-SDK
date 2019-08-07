package info.uuia.sdk;

import info.uuia.sdk.util.Semester;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SdkApplication {

    public static void main(String[] args) {
        Semester.init();
        SpringApplication.run(SdkApplication.class, args);
    }

}
