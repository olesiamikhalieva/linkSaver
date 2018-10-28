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


@Controller
@RequestMapping("/linksSaver")
//@Log4j2
public class StartController {
@Autowired
private UserLinksService userLinksService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMain(Model model) {
        model.addAttribute("start", "hello");
        model.addAttribute("allLinksList", userLinksService.getLinkFormDtoSetFromDB());
       // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       // System.out.println(authentication.getPrincipal().toString());
        return "mainLink";
    }

    @GetMapping("/add")
    public String addLink(@ModelAttribute LinkFormDto linkFormDto) {
        System.out.println(linkFormDto);
       userLinksService.addLinkFormDtoToDB(linkFormDto);
        return "redirect:/linksSaver";
    }

    @DeleteMapping("/delete")
    public String deleteLink(@ModelAttribute LinkFormDto linkFormDto) {
        userLinksService.deleteLinkFromDB(linkFormDto);
        return "redirect:/linksSaver";
    }

//    @GetMapping("/search")
//    public String searchByTheme(HttpServletRequest request, Model model){
//        String tagName = request.getParameter("tagName");
//        System.out.println(tagName);
//        model.addAttribute("allLinksList", linkService.getLinkFormDtoSetByTagName(tagName));
//        return "kautube/kautube2";
//    }

    @GetMapping("/hi")
    public String getAll(Model model) {
        return "hi";
    }


}
