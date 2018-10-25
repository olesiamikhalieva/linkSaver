package com.linksSaver.dao.repository;

import com.linksSaver.dao.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface TagRepository extends JpaRepository <TagEntity, Long> {

    Set<TagEntity> findByTagName(String tagName);










}
