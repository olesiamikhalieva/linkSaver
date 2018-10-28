//package com.linksSaver.service.impl;
//
//import com.linksSaver.dao.entity.LinkEntity;
//import com.linksSaver.dao.entity.TagEntity;
//import com.linksSaver.dao.entity.securityEntities.UserInfo;
//import com.linksSaver.dao.repository.LinkRepository;
//import com.linksSaver.dao.repository.TagRepository;
//import com.linksSaver.dao.repository.securityRepository.UserRepository;
//import com.linksSaver.dto.LinkFormDto;
//import com.linksSaver.service.LinkService;
//import com.linksSaver.service.UserInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Service
//@Transactional
//public class LinkServiceImpl implements LinkService {
//
//    @Autowired
//    private LinkRepository linkRepository;
//
//    @Autowired
//    private TagRepository tagRepository;
//
//    @Autowired
//    private UserInfoService userInfoService;
//
//
//    //get all linkFormDtos
////    public Set<LinkFormDto> getLinkFormDtoSet() {
////        Set<LinkFormDto> linkFormDtos = new HashSet<>();
////        for (TagEntity tagEntity : tagRepository.findAll()) {
////            constructLinkFormDtoFromTagEntity(linkFormDtos, tagEntity);
////        }
////        return linkFormDtos;
////    }
//
//
////    //get links by tagName
////    public Set<LinkFormDto> getLinkFormDtoSetByTagName(String tagName) {
////        Set<LinkFormDto> linkFormDtos = new HashSet<>();
////        for (TagEntity tagEntity : tagRepository.findByTagName(tagName)) {
////            constructLinkFormDtoFromTagEntity(linkFormDtos, tagEntity);
////        }
////        return linkFormDtos;
////    }
//
////    private void constructLinkFormDtoFromTagEntity(Set<LinkFormDto> linkFormDtos, TagEntity tagEntity) {
////        for (LinkEntity link : tagEntity.getLinks()) {
////            LinkFormDto linkFormDto = new LinkFormDto();
////            linkFormDto.setTagName(tagEntity.getTagName());
////            linkFormDto.setLinkName(link.getLinkName());
////            linkFormDto.setDescription(link.getDescription());
////            linkFormDtos.add(linkFormDto);
////        }
////    }
//
//    //add link to DB
//    public String addTagDtoToDB(LinkFormDto linkFormDto) {
//        TagEntity tagEntity = checkUniqueTag(linkFormDto.getTagName());
//        if (tagEntity == null) {
//            tagEntity = constructTagEntityFromLinkFormDto(linkFormDto);
//            userInfoService.addTagSetToUserInfo(tagEntity);
//            try {
//                tagRepository.saveAndFlush(tagEntity);
//                System.out.println("before update1");
//                userInfoService.updateUserInfo();
//                return "link is saved";
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "error saved link";
//            }
//        } else {
//            updateTagEntity(linkFormDto, tagEntity);
//            userInfoService.addTagSetToUserInfo(tagEntity);
//            try {
//                tagRepository.saveAndFlush(tagEntity);
//                System.out.println("before update2");
//                userInfoService.updateUserInfo();
//                return "link is update";
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "link is not update";
//            }
//        }
//    }
//
//    private void updateTagEntity(LinkFormDto linkFormDto, TagEntity tagEntity) {
//        LinkEntity linkEntity = new LinkEntity();
//        linkEntity.setLinkName(linkFormDto.getLinkName());
//        linkEntity.setDescription(linkFormDto.getDescription());
//        linkEntity.setDate(new Date());
//        Set<LinkEntity> links = tagEntity.getLinks();
//        links.add(linkEntity);
//        tagEntity.setLinks(links);
//    }
//
//    private TagEntity constructTagEntityFromLinkFormDto(LinkFormDto linkFormDto) {
//        TagEntity tagEntity;
//        Set<LinkEntity> links = new HashSet<>();
//        LinkEntity linkEntity = new LinkEntity();
//        linkEntity.setLinkName(linkFormDto.getLinkName());
//        linkEntity.setDescription(linkFormDto.getDescription());
//        linkEntity.setDate(new Date());
//        links.add(linkEntity);
//        tagEntity = new TagEntity();
//        tagEntity.setTagName(linkFormDto.getTagName());
//        tagEntity.setLinks(links);
//
//        return tagEntity;
//    }
//
//
//
//    public void deleteLinkFromDB(LinkFormDto linkFormDto) {
//        linkRepository.deleteByLinkName(linkFormDto.getLinkName());
//    }
//
//
//    private TagEntity checkUniqueTag(String tagName) {
//        for (TagEntity tagEntity : tagRepository.findAll()) {
//            if (tagName.equals(tagEntity.getTagName())) {
//                return tagEntity;
//            }
//        }
//        return null;
//    }
//
//}
//
