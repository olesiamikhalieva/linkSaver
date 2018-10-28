package com.linksSaver.dao.repository;

import com.linksSaver.dao.entity.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<LinkEntity,Long> {

    void deleteLinkEntityByLinkName(String name);
}
