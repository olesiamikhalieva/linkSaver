package com.linksSaver.controller;

import com.linksSaver.dto.LinkFormDto;
import com.linksSaver.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/linksSaver")
//@Log4j2
public class StartController {
@Autowired
LinkService linkService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMain(Model model) {
        model.addAttribute("start", "hello");
        model.addAttribute("allLinksList", linkService.getLinkFormDtoSet());
       // System.out.println(linkService.getLinkFormDtoSet());
        return "mainLink";
    }

    @GetMapping("/add")
    public String addLink(@ModelAttribute LinkFormDto linkFormDto) {
        System.out.println(linkFormDto);
       linkService.addTagDtoToDB(linkFormDto);
        return "redirect:/linksSaver";
    }

    @GetMapping("/delete")
    public String deleteLink(@ModelAttribute LinkFormDto linkFormDto) {
        linkService.deleteLinkFromDB(linkFormDto);
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
