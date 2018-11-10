package com.linksSaver.service;

import com.linksSaver.dao.entity.LinkEntity;
import com.linksSaver.dao.entity.TagEntity;
import com.linksSaver.dao.entity.securityEntities.UserInfo;
import com.linksSaver.dao.repository.LinkRepository;
import com.linksSaver.dao.repository.TagRepository;
import com.linksSaver.dao.repository.securityRepository.UserRepository;
import com.linksSaver.dto.LinkFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserLinksServiceImpl implements UserLinksService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LinkRepository linkRepository;


    //add link to DB
    @Override
    @Transactional
    public void addLinkFormDtoToDB(LinkFormDto linkFormDto) {
        LinkEntity linkEntity = constructLinkEntityFromLinkFormDto(linkFormDto);
        getCurrentUserInfo().getLinks().add(linkEntity);
        System.out.println("get to user links");
        try {
            userRepository.saveAndFlush(getCurrentUserInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional
    public Set<LinkFormDto> getLinkFormDtoSetFromDB() {
        Set<LinkFormDto> linkFormDtos = new HashSet<>();
        for (LinkEntity link : getCurrentUserInfo().getLinks()) {
            LinkFormDto linkFormDto = constructLinkFormDtoFromLinkEntity(link);
            linkFormDtos.add(linkFormDto);
        }
        return linkFormDtos;
    }


    @Override
    @Transactional
    public Set<LinkFormDto> getLinkFormDtoSetFromDBByUserInfo(UserInfo userInfo) {
        Set<LinkFormDto> linkFormDtos = new HashSet<>();
        for (LinkEntity link : userInfo.getLinks()) {
            LinkFormDto linkFormDto = constructLinkFormDtoFromLinkEntity(link);
            linkFormDtos.add(linkFormDto);
        }
        return linkFormDtos;
    }

    //get links by tagName
    @Override
    @Transactional
    public Set<LinkFormDto> getLinkFormDtoSetByTagName(String tagName) {
        UserInfo userInfo = getCurrentUserInfo();
        Set<LinkFormDto> linkFormDtos = new HashSet<>();
        for (LinkEntity link : userInfo.getLinks()) {
            for (TagEntity tag : link.getTags()) {
                if (tagName.equals(tag.getTagName())) {
                    LinkFormDto linkFormDto = constructLinkFormDtoFromLinkEntity(link);
                    linkFormDtos.add(linkFormDto);
                }
            }
        }
        return linkFormDtos;
    }


    @Override
    @Transactional
    public void deleteLinkFromDB(String linkName) {
        linkRepository.deleteLinkEntityByLinkName(linkName);
    }


    private UserInfo getCurrentUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = userRepository.findByUsername(authentication.getName());
        System.out.println("UserInfo at begin userInfoService: " + userInfo);
        return userInfo;
    }


    private LinkFormDto constructLinkFormDtoFromLinkEntity(LinkEntity linkEntity) {
        LinkFormDto linkFormDto = new LinkFormDto();
        List<TagEntity> tags = linkEntity.getTags();
        System.out.println("TAG"+tags+"----"+tags.size());
        if (tags.size()!=0){
        linkFormDto.setTag1(tags.get(0).getTagName());
        linkFormDto.setTag2(tags.get(1).getTagName());
        linkFormDto.setTag3(tags.get(2).getTagName());}
        linkFormDto.setLinkName(linkEntity.getLinkName());
        linkFormDto.setDescription(linkEntity.getDescription());
        return linkFormDto;
    }


    private LinkEntity constructLinkEntityFromLinkFormDto(LinkFormDto linkFormDto) {
        List<TagEntity> tags = new ArrayList<>();
        TagEntity tagEntity1 = new TagEntity();
        tagEntity1.setTagName(linkFormDto.getTag1());
        tags.add(tagEntity1);
        TagEntity tagEntity2 = new TagEntity();
        tagEntity2.setTagName(linkFormDto.getTag2());
        tags.add(tagEntity2);
        TagEntity tagEntity3 = new TagEntity();
        tagEntity3.setTagName(linkFormDto.getTag3());
        tags.add(tagEntity3);
        Set<LinkEntity> links = new HashSet<>();
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setLinkName(linkFormDto.getLinkName());
        linkEntity.setDescription(linkFormDto.getDescription());
        linkEntity.setDate(new Date());
        linkEntity.setTags(tags);
        links.add(linkEntity);
        return linkEntity;
    }

}
