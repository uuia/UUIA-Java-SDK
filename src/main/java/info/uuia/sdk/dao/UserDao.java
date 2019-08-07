package info.uuia.sdk.dao;

import info.uuia.sdk.dao.entity.UserDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserDo,Long> {
    public UserDo findFirstByUuid(String uuid);
}
