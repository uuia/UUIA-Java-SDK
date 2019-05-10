package info.uuia.sdk.service;

import info.uuia.sdk.domain.exam.Exam;
import info.uuia.sdk.exception.LackNecessaryInfoException;
import info.uuia.sdk.factory.DataRepositoryFactory;
import info.uuia.sdk.repository.DataRepository;

import java.lang.reflect.InvocationTargetException;

class ReturnExam extends ReturnData<Exam> {

    @Override
    void check(Exam data) throws LackNecessaryInfoException {
        if (data.getUuid() == null) {
            throw new LackNecessaryInfoException("Need String uuid as a property of " + data.getClass().getName());
        } else if (data.getCourses() == null) {
            throw new LackNecessaryInfoException("Need Array courses as a property of " + data.getClass().getName());
        }
    }

    @Override
    DataRepository<Exam> produce() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return DataRepositoryFactory.getExamDataRepository();
    }
}
