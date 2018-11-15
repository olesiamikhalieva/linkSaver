package com.linksSaver.controller;

import com.linksSaver.dao.entity.securityEntities.UserInfo;
import com.linksSaver.dto.LinkFormDto;
import com.linksSaver.service.UserLinksService;
import com.linksSaver.service.securityService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory
            .getLogger(AdminController.class);

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
        logger.info("Returning admin.jsp page");
        return "admin";
    }

    @GetMapping("/admin/delete/{id}")
    public String main(@RequestParam Long id){
        try {
            userService.deleteById(id);
            logger.info("Delete user with id: "+id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error deleting user by id.");
        }

        return "redirect:/admin";
    }

    @GetMapping("/admin/show/{name}")
    public String show(@PathVariable String name){
        logger.info("Show user with name: "+name);
        userName = name;
        try {
            UserInfo userInfo = userService.findByUsername(name);
            linkFormDtoSet = userLinksService.getLinkFormDtoSetFromDBByUserInfo(userInfo);
            logger.info("Information by user with name: "+name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error with finding user with name: "+name);
        }
        return "redirect:/admin";
    }

}
