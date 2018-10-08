package com.linksSaver.controller;

import com.linksSaver.dao.entity.LinkEntity;
import com.linksSaver.dao.repository.impl.LinkDaoImpl;
import com.linksSaver.dto.LinkDto;
import com.linksSaver.dto.ThemeDto;
import com.linksSaver.service.impl.LinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/linksSaver")
public class StartController {
@Autowired
    LinkServiceImpl linkService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMain(Model model) {
        model.addAttribute("start", "hello");
        return "kautube/kautube";
    }

    @GetMapping("/add")
    public void addLink(@ModelAttribute LinkDto linkDto) {
        System.out.println(linkDto.getLinkName());


     //   System.out.println(linkEntity.getThemeEntities());
    }
}
