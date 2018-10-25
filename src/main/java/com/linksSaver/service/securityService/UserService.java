package com.linksSaver.service.securityService;


import com.linksSaver.dao.entity.securityEntities.UserInfo;

public interface UserService {
    void save(UserInfo userInfo);

    UserInfo findByUsername(String username);
}
