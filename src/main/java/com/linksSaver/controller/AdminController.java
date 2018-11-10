package com.linksSaver.controller;

import com.linksSaver.dao.entity.securityEntities.UserInfo;
import com.linksSaver.dto.LinkFormDto;
import com.linksSaver.service.UserLinksService;
import com.linksSaver.service.securityService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLinksService userLinksService;

    private Set<LinkFormDto> linkFormDtoSet = new HashSet<>();

    private String userName;

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("userList", userService.allUsers());
        model.addAttribute("linkList", linkFormDtoSet);
        model.addAttribute("user", userName);

        return "admin";
    }

    @GetMapping("/admin/delete/{id}")
    public String main(@RequestParam Long id){
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/show/{name}")
    public String show(@PathVariable String name, Model model){
        UserInfo userInfo = userService.findByUsername(name);
        userName = userInfo.getUsername();
        linkFormDtoSet = userLinksService.getLinkFormDtoSetFromDBByUserInfo(userInfo);
        return "redirect:/admin";
    }
}
