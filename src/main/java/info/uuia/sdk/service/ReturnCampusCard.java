package info.uuia.sdk.service;

import info.uuia.sdk.domain.campuscard.CampusCard;
import info.uuia.sdk.exception.LackNecessaryInfoException;
import info.uuia.sdk.factory.DataRepositoryFactory;
import info.uuia.sdk.repository.DataRepository;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

class ReturnCampusCard extends ReturnData<CampusCard> {

    @Override
    void check(@Valid CampusCard data) throws LackNecessaryInfoException {
        if (data.getUuid() == null) {
            throw new LackNecessaryInfoException("Need String uuid as a property of " + data.getClass().getName());
        } else if (data.getBalance() == null) {
            throw new LackNecessaryInfoException("Need Double balance as a property of " + data.getClass().getName());
        }
    }

    @Override
    DataRepository<CampusCard> produce() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return DataRepositoryFactory.getCampusCardDataRepository();
    }
}
