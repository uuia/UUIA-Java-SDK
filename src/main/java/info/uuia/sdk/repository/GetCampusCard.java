package info.uuia.sdk.repository;

import info.uuia.sdk.domain.campuscard.CampusCard;
import info.uuia.sdk.util.NotImplementedException;

public class GetCampusCard implements DataRepository<CampusCard> {

    @Override
    public CampusCard getData(String uuid) throws NotImplementedException {
        // TODO: 在此实现你的数据获取逻辑 / Implement your data obtaining logic here
        throw new NotImplementedException("没有实现此数据获取逻辑");
    }
}
