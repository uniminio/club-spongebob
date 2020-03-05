package com.kotei.magicconch.clubspongebob.controller;

import com.kotei.magicconch.clubspongebob.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping(value = "/admin/user/list",method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("userList",adminUserService.getAllUser());
        return "admin/user_list";
    }
}
