package info.uuia.repository;

import info.uuia.domain.schedule.Schedule;
import info.uuia.util.NotImplementedException;

public class GetSchedule implements DataRepository<Schedule>{

    @Override
    public Schedule getData(String uuid) throws NotImplementedException {
        // TODO: 在此实现你的数据获取逻辑 / Implement your data obtaining logic here
        throw new NotImplementedException("没有实现此数据获取逻辑");
    }
}
