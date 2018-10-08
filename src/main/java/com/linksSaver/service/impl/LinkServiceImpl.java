package com.linksSaver.service.impl;

import com.linksSaver.dao.entity.LinkEntity;
import com.linksSaver.dao.entity.ThemeEntity;
import com.linksSaver.dao.repository.LinkDao;
import com.linksSaver.dto.LinkDto;
import com.linksSaver.dto.ThemeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LinkServiceImpl {
    @Autowired
    private LinkDao linkDao;


    public List<LinkDto> getLinksList() {
        List<LinkDto> linkDtos = new ArrayList<>();
        for (LinkEntity linkEntity : linkDao.getLinksList()) {
            LinkDto linkDto = new LinkDto();
            linkDto.setLinkName(linkEntity.getLink_name());
            ThemeDto themeDto = new ThemeDto();
            themeDto.setNameTheme(linkEntity.getTheme().getName_theme());
            linkDto.setThemeDto(themeDto);
            linkDtos.add(linkDto);
        }
        return linkDtos;
    }

    public List<ThemeDto> getThemeDtoList() {
        List<ThemeDto> themeDtos = new ArrayList<>();
        for (ThemeEntity themeEntity : linkDao.getThemeList()) {
            ThemeDto themeDto = new ThemeDto();
            themeDto.setNameTheme(themeEntity.getName_theme());
            themeDtos.add(themeDto);
        }
        return themeDtos;
    }

    public void addLinkDtoToDB(LinkDto linkDto) {
        try {
            LinkEntity linkEntity = constructLinkEntityFromLinkDto(linkDto);
            linkDao.saveOrUpdate(linkEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Boolean checkUniqueTheme(String theme) {
        boolean check = false;
        for (ThemeDto themeDto : getThemeDtoList()) {
            if (theme.equals(themeDto.getNameTheme())) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }

    private LinkEntity constructLinkEntityFromLinkDto(LinkDto linkDto) {
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setLink_name(linkDto.getLinkName());
        ThemeEntity themeEntity = new ThemeEntity();
        themeEntity.setName_theme(linkDto.getThemeDto().getNameTheme());
        linkEntity.setTheme(themeEntity);
        return linkEntity;
    }

    public void deleteLink(LinkDto linkDto){
        try {
            LinkEntity linkEntity = constructLinkEntityFromLinkDto(linkDto);
            linkDao.removeByLinkName(linkEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

