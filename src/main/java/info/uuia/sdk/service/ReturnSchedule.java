package info.uuia.sdk.service;

import info.uuia.sdk.domain.schedule.Schedule;
import info.uuia.sdk.exception.LackNecessaryInfoException;
import info.uuia.sdk.factory.DataRepositoryFactory;
import info.uuia.sdk.repository.DataRepository;

import java.lang.reflect.InvocationTargetException;

class ReturnSchedule extends ReturnData<Schedule> {

    @Override
    void check(Schedule data) throws LackNecessaryInfoException {
        if (data.getUuid() == null) {
            throw new LackNecessaryInfoException("Need String uuid as a property of " + data.getClass().getName());
        } else if (data.getCourses() == null) {
            throw new LackNecessaryInfoException("Need Array courses as a property of " + data.getClass().getName());
        }
    }

    @Override
    DataRepository<Schedule> produce() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return DataRepositoryFactory.getScheduleDataRepository();
    }
}
