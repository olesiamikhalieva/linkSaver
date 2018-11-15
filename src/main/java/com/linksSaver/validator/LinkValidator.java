package com.linksSaver.validator;

import com.linksSaver.dao.entity.LinkEntity;
import com.linksSaver.dao.entity.securityEntities.UserInfo;
import com.linksSaver.dao.repository.LinkRepository;
import com.linksSaver.dto.LinkFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class LinkValidator {

    public String validate(LinkFormDto linkFormDto, Set<LinkFormDto> links){
        String check = "\\S+";
        if (linkFormDto.getLinkName().matches(check)==false) {
            return "Link is a required field.";
        }
            for (LinkFormDto link : links) {
                if (link.getLinkName().equals(linkFormDto.getLinkName())){
                    return "This link is exist.";
                }
            }
        return "ok";
    }
}
