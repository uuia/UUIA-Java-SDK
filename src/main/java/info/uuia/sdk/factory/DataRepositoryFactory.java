package info.uuia.sdk.factory;

import info.uuia.sdk.domain.campuscard.CampusCard;
import info.uuia.sdk.domain.exam.Exam;
import info.uuia.sdk.domain.schedule.Schedule;
import info.uuia.sdk.domain.score.Score;
import info.uuia.sdk.domain.userinfo.UserInfo;
import info.uuia.sdk.repository.DataRepository;

import java.lang.reflect.InvocationTargetException;

public class DataRepositoryFactory {
    private static Class<DataRepository<CampusCard>> campusCardDataRepositoryClass;
    private static Class<DataRepository<Exam>> examDataRepositoryClass;
    private static Class<DataRepository<Schedule>> scheduleDataRepositoryClass;
    private static Class<DataRepository<Score>> scoreDataRepositoryClass;
    private static Class<DataRepository<UserInfo>> userInfoDataRepositoryClass;

    public static void validate() throws NotCompletelyInitializedException {
        if (!(campusCardDataRepositoryClass != null && examDataRepositoryClass != null && scheduleDataRepositoryClass != null && scoreDataRepositoryClass != null && userInfoDataRepositoryClass != null)) {
            throw new NotCompletelyInitializedException("数据仓库未完全初始化");
        }
    }

    public static DataRepository<CampusCard> getCampusCardDataRepository() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return campusCardDataRepositoryClass.getDeclaredConstructor().newInstance();
    }

    public static void setCampusCardDataRepositoryClass(Class<DataRepository<CampusCard>> campusCardDataRepositoryClass) {
        DataRepositoryFactory.campusCardDataRepositoryClass = campusCardDataRepositoryClass;
    }

    public static DataRepository<Exam> getExamDataRepository() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return examDataRepositoryClass.getDeclaredConstructor().newInstance();
    }

    public static void setExamDataRepositoryClass(Class<DataRepository<Exam>> examDataRepositoryClass) {
        DataRepositoryFactory.examDataRepositoryClass = examDataRepositoryClass;
    }

    public static DataRepository<Schedule> getScheduleDataRepository() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return scheduleDataRepositoryClass.getDeclaredConstructor().newInstance();
    }

    public static void setScheduleDataRepositoryClass(Class<DataRepository<Schedule>> scheduleDataRepositoryClass) {
        DataRepositoryFactory.scheduleDataRepositoryClass = scheduleDataRepositoryClass;
    }

    public static DataRepository<Score> getScoreDataRepository() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return scoreDataRepositoryClass.getDeclaredConstructor().newInstance();
    }

    public static void setScoreDataRepositoryClass(Class<DataRepository<Score>> scoreDataRepositoryClass) {
        DataRepositoryFactory.scoreDataRepositoryClass = scoreDataRepositoryClass;
    }

    public static DataRepository<UserInfo> getUserInfoDataRepository() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return userInfoDataRepositoryClass.getDeclaredConstructor().newInstance();
    }

    public static void setUserInfoDataRepositoryClass(Class<DataRepository<UserInfo>> userInfoDataRepositoryClass) {
        DataRepositoryFactory.userInfoDataRepositoryClass = userInfoDataRepositoryClass;
    }
}
