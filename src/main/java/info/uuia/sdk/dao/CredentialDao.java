package info.uuia.sdk.dao;

import info.uuia.sdk.dao.entity.CredentialDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialDao extends JpaRepository<CredentialDo,Long> {
    public CredentialDo findFirstByUuid(String uuid);
}
