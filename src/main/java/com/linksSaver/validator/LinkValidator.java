package com.linksSaver.validator;

import com.linksSaver.dao.repository.LinkRepository;
import com.linksSaver.dto.LinkFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkValidator {

    @Autowired
    private LinkRepository linkRepository;

    public String validate(LinkFormDto linkFormDto){
        String check = "\\S+";
        if (linkFormDto.getLinkName().matches(check)==false) {
            return "Link is a required field.";
        }
//        if (linkRepository.findByLinkName(linkFormDto.getLinkName())!=null) {
//          return "This link is exist.";
//        }
        return "ok";
    }
}
