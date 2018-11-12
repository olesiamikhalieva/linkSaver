package com.linksSaver.service;

import com.linksSaver.dao.entity.securityEntities.UserInfo;
import com.linksSaver.dto.LinkFormDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface UserLinksService {

    Set<LinkFormDto> getLinkFormDtoSetFromDB();

    void addLinkFormDtoToDB(LinkFormDto linkFormDto);

    void deleteLinkFromDB(String linkName);

    @Transactional
    Set<LinkFormDto> getLinkFormDtoSetFromDBByUserInfo(UserInfo userInfo);

    Set<LinkFormDto> getLinkFormDtoSetByTagName(String tagName);

    boolean findLinkByName(String name);
}
