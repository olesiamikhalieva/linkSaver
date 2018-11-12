package com.linksSaver.controller;

import com.linksSaver.dto.LinkFormDto;
import com.linksSaver.service.UserLinksService;
import com.linksSaver.validator.LinkValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/linksSaver")

public class StartController {

    @Autowired
    private UserLinksService userLinksService;

    @Autowired
    private LinkValidator linkValidator;

    private static final Logger logger = LoggerFactory
            .getLogger(StartController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getMain(Model model) {
        logger.info("Returning mainLink.jsp page");
        model.addAttribute("allLinksList", userLinksService.getLinkFormDtoSetFromDB());
        return "mainLink";
    }

    @GetMapping("/add")
    public String addLink(@ModelAttribute LinkFormDto linkFormDto) {
        try {
            if (linkValidator.validate(linkFormDto).equals("ok")) {
                userLinksService.addLinkFormDtoToDB(linkFormDto);
                logger.info("Add linkFormDto " + linkFormDto.getLinkName());
            }else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/linksSaver";
    }

    @GetMapping("/delete/{linkName}")
    public String deleteLink(@PathVariable String linkName) {
        try {
            userLinksService.deleteLinkFromDB(linkName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Delete " + linkName);
        return "redirect:/linksSaver";
    }

    @GetMapping("/search")
    public String searchByTheme(@RequestParam String tagName, Model model) {
        logger.info("Search tag: " + tagName);
        model.addAttribute("allLinksList", userLinksService.getLinkFormDtoSetByTagName(tagName));
        return "mainLink";
    }

}
