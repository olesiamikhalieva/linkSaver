package com.linksSaver.service.securityService;


import com.linksSaver.dao.entity.securityEntities.UserInfo;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    void save(UserInfo userInfo);

    UserInfo findByUsername(String username);

//    @Transactional
//    void update();
}
