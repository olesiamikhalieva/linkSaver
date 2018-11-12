package com.linksSaver.service.securityService;


import com.linksSaver.dao.entity.securityEntities.Role;
import com.linksSaver.dao.entity.securityEntities.UserInfo;
import com.linksSaver.dao.repository.securityRepository.RoleRepository;
import com.linksSaver.dao.repository.securityRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    @Transactional
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        Role role = roleRepository.getOne(2L);
        Set<Role> roles = new HashSet<>(Collections.singleton(role));
        userInfo.setRoles(roles);
       // System.out.println(userInfo);
       // System.out.println(roles);
        userRepository.save(userInfo);

    }


    @Override
    public UserInfo findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserInfo> allUsers() {
        return userRepository.findAll();
    }
    @Override
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

}
