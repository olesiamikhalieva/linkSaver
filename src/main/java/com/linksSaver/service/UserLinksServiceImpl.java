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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserLinksServiceImpl implements UserLinksService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private TagRepository tagRepository;


    //add link to DB
    @Override
    @Transactional
    public String addLinkFormDtoToDB(LinkFormDto linkFormDto) {
        TagEntity tagEntity = checkUniqueTag(linkFormDto.getTagName());
        if (tagEntity == null) {
            tagEntity = constructTagEntityFromLinkFormDto(linkFormDto);
            try {
                tagRepository.saveAndFlush(tagEntity);
                updateUserInfo(getCurrentUserInfo());
                return "link is saved";
            } catch (Exception e) {
                e.printStackTrace();
                return "error saved link";
            }
        } else {
            updateTagEntity(linkFormDto, tagEntity);
            try {
                tagRepository.saveAndFlush(tagEntity);
                updateUserInfo(getCurrentUserInfo());
                return "link is update";
            } catch (Exception e) {
                e.printStackTrace();
                return "link is not update";
            }
        }
    }


    @Override
    @Transactional
    public Set<LinkFormDto> getLinkFormDtoSetFromDB() {
        UserInfo userInfo = getCurrentUserInfo();
        Set<LinkFormDto> linkFormDtos = new HashSet<>();
        for (TagEntity tagEntity : userInfo.getTags()) {
            constructLinkFormDtoFromTagEntity(linkFormDtos, tagEntity);
        }
        return linkFormDtos;
    }


    //get links by tagName
    @Override
    @Transactional
    public Set<LinkFormDto> getLinkFormDtoSetByTagName(String tagName) {
        UserInfo userInfo = getCurrentUserInfo();
        Set<LinkFormDto> linkFormDtos = new HashSet<>();
        for (TagEntity tag : userInfo.getTags()) {
            if (tagName.equals(tag.getTagName())) {
                constructLinkFormDtoFromTagEntity(linkFormDtos, tag);
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


    private void updateUserInfo(UserInfo userInfo) {
        userRepository.saveAndFlush(userInfo);
    }


    private void constructLinkFormDtoFromTagEntity(Set<LinkFormDto> linkFormDtos, TagEntity tagEntity) {
        for (LinkEntity link : tagEntity.getLinks()) {
            LinkFormDto linkFormDto = new LinkFormDto();
            linkFormDto.setTagName(tagEntity.getTagName());
            linkFormDto.setLinkName(link.getLinkName());
            linkFormDto.setDescription(link.getDescription());
            linkFormDtos.add(linkFormDto);
        }
    }


    private void updateTagEntity(LinkFormDto linkFormDto, TagEntity tagEntity) {
        getCurrentUserInfo();
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setLinkName(linkFormDto.getLinkName());
        linkEntity.setDescription(linkFormDto.getDescription());
        linkEntity.setDate(new Date());
        Set<LinkEntity> links = tagEntity.getLinks();
        links.add(linkEntity);
        tagEntity.setLinks(links);
        getCurrentUserInfo().getTags().add(tagEntity);
    }


    private TagEntity constructTagEntityFromLinkFormDto(LinkFormDto linkFormDto) {
        Set<LinkEntity> links = new HashSet<>();
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setLinkName(linkFormDto.getLinkName());
        linkEntity.setDescription(linkFormDto.getDescription());
        linkEntity.setDate(new Date());
        links.add(linkEntity);
        TagEntity tagEntity = new TagEntity();
        tagEntity.setTagName(linkFormDto.getTagName());
        tagEntity.setLinks(links);
        getCurrentUserInfo().getTags().add(tagEntity);
        return tagEntity;
    }


    private TagEntity checkUniqueTag(String tagName) {
        UserInfo userInfo = getCurrentUserInfo();
        for (TagEntity tagEntity : userInfo.getTags()) {
            if (tagName.equals(tagEntity.getTagName())) {
                return tagEntity;
            }
        }
        return null;
    }
}
