package com.linksSaver.dao.repository.impl;

import com.linksSaver.dao.entity.LinkEntity;
import com.linksSaver.dao.entity.ThemeEntity;
import com.linksSaver.dao.repository.LinkDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class LinkDaoImpl implements LinkDao {


    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<LinkEntity> getLinksList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<LinkEntity> theQuery = currentSession.createQuery("from LinkEntity", LinkEntity.class);
        return theQuery.getResultList();
    }
    @Override
    public List<ThemeEntity> getThemeList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<ThemeEntity> theQuery = currentSession.createQuery("from ThemeEntity", ThemeEntity.class);
        return theQuery.getResultList();
    }
    @Override
    public LinkEntity getLinksById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        LinkEntity linksSEntity = currentSession.get(LinkEntity.class, id);
        return linksSEntity;
    }

    @Override
    public ThemeEntity getThemeById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        ThemeEntity themeEntity = currentSession.get(ThemeEntity.class, id);
        return themeEntity;
    }
    @Override
    public List<LinkEntity> getLinksByTheme(String theme) {
        Session currentSession = sessionFactory.getCurrentSession();
        ThemeEntity themeEntity = currentSession.get(ThemeEntity.class, theme);
        Set<LinkEntity> linkEntitiesSet = themeEntity.getLink_entities();
        List<LinkEntity> linkEntitiesList = new ArrayList<>(linkEntitiesSet);
//        Query query = currentSession.createQuery("FROM ThemeEntity T WHERE T.themeName = 1");
//        query.setParameter(1, theme);
//        List<ThemeEntity>themeEntities = query.list();
//        for (ThemeEntity themeEntity : themeEntities) {
//            List<LinkEntity> linkEntities = new ArrayList<>();
//            linkEntities.add(themeEntity.getLinkEntities());
//        }
        return linkEntitiesList;
    }

    @Override
    public void saveOrUpdate(LinkEntity linkEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(linkEntity);
    }

    @Override
    public void removeByLinkName(LinkEntity linkEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        LinkEntity linkEntityDB = currentSession.get(LinkEntity.class, linkEntity.getLink_name());
           currentSession.remove(linkEntityDB);
        }

}
