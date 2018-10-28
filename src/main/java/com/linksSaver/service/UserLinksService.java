package com.linksSaver.service;

import com.linksSaver.dto.LinkFormDto;

import java.util.Set;

public interface UserLinksService {

    Set<LinkFormDto> getLinkFormDtoSetFromDB();

    String addLinkFormDtoToDB(LinkFormDto linkFormDto);

    void deleteLinkFromDB(LinkFormDto linkFormDto);

    Set<LinkFormDto> getLinkFormDtoSetByTagName(String tagName);
}
