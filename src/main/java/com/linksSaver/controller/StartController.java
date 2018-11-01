package com.linksSaver.controller;

import com.linksSaver.dto.LinkFormDto;
import com.linksSaver.service.UserLinksService;
import com.linksSaver.service.UserLinksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/linksSaver")
//@Log4j2
public class StartController {
    
@Autowired
private UserLinksService userLinksService;

private Set<LinkFormDto> linkFormDtos = new HashSet<>();


    @RequestMapping(method = RequestMethod.GET)
    public String getMain(Model model) {
        model.addAttribute("allLinksList", userLinksService.getLinkFormDtoSetFromDB());
        return "mainLink";
    }

    @GetMapping("/add")
    public String addLink(@ModelAttribute LinkFormDto linkFormDto) {
        System.out.println(linkFormDto);
       userLinksService.addLinkFormDtoToDB(linkFormDto);
        return "redirect:/linksSaver";
    }

    @GetMapping("/delete/{linkName}")
    public String deleteLink(Model model,@PathVariable String linkName) {
        //model.addAttribute("allLinksList", userLinksService.getLinkFormDtoSetFromDB());
        userLinksService.deleteLinkFromDB(linkName);
        return "redirect:/linksSaver";
    }

    @GetMapping("/search")
    public String searchByTheme(@RequestParam String tagName, Model model){
        System.out.println("tagName"+tagName);
        model.addAttribute("allLinksList", userLinksService.getLinkFormDtoSetByTagName(tagName));
        return "mainLink";
    }



}
