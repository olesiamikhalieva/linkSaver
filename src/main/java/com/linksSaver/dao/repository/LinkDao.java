package com.linksSaver.dao.repository;

import com.linksSaver.dao.entity.LinkEntity;
import com.linksSaver.dao.entity.ThemeEntity;

import java.util.List;

public interface LinkDao {

    List<LinkEntity> getLinksList();

    List<ThemeEntity> getThemeList();

    LinkEntity getLinksById(long id);

    ThemeEntity getThemeById(long id);

    List<LinkEntity> getLinksByTheme(String theme);

    void saveOrUpdate(LinkEntity linkEntity);

    void removeByLinkName(LinkEntity linkEntity);
}
