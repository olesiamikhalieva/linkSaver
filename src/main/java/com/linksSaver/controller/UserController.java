package com.linksSaver.controller;

import com.linksSaver.dao.entity.securityEntities.UserInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String start() {
        return "redirect:/login";
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model, @AuthenticationPrincipal UserInfo userInfo, Principal principal, HttpServletRequest servletRequest) {
        try {
            System.out.println(userInfo.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(principal.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(servletRequest.getUserPrincipal().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "welcome";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String userok(Model model) {
        return "home";
    }
}
