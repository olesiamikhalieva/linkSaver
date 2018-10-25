package com.linksSaver.dao.repository.securityRepository;


import com.linksSaver.dao.entity.securityEntities.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
