package com.linksSaver.controller;

import com.linksSaver.dto.LinkFormDto;
import com.linksSaver.service.UserLinksService;
import com.linksSaver.service.securityService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/linksSaver")

public class StartController {
    
@Autowired
private UserLinksService userLinksService;


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
    public String deleteLink(@PathVariable String linkName) {
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
