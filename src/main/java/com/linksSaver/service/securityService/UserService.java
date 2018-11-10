package com.linksSaver.service.securityService;


import com.linksSaver.dao.entity.securityEntities.UserInfo;

import java.util.List;

public interface UserService {
    void save(UserInfo userInfo);
    UserInfo findByUsername(String username);
    List<UserInfo> allUsers();
    void deleteById(Long id);
}
