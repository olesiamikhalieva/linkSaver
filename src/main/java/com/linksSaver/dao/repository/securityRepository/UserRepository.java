package com.linksSaver.dao.repository.securityRepository;

import com.linksSaver.dao.entity.LinkEntity;
import com.linksSaver.dao.entity.securityEntities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * стандартный JPA репозиторий который работает с объектами.
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
    void deleteById(Long id);
}
