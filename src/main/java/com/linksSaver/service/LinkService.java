package com.linksSaver.service;

import com.linksSaver.dto.LinkFormDto;

import java.util.Set;

public interface LinkService {

   Set<LinkFormDto> getLinkFormDtoSet();

    Set<LinkFormDto> getLinkFormDtoSetByTagName(String themeName);

    String addTagDtoToDB(LinkFormDto linkFormDto);

    void deleteLinkFromDB(LinkFormDto linkFormDto);


}
