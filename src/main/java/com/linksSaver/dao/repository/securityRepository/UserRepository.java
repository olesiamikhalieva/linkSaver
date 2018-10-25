package com.linksSaver.dao.repository.securityRepository;

import com.linksSaver.dao.entity.securityEntities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * стандартный JPA репозиторий который работает с объектами.
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
