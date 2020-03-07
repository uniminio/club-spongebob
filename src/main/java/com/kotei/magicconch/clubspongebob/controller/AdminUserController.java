package com.kotei.magicconch.clubspongebob.controller;

import com.kotei.magicconch.clubspongebob.dto.RegisterDTO;
import com.kotei.magicconch.clubspongebob.service.AdminUserService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping(value = "/admin/user/list",method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("userList",adminUserService.getAllUser());
        return "admin/user_list";
    }

    @RequestMapping(value = "/admin/user/edit/{id}",method = RequestMethod.POST)
    public String editUser(@PathVariable String id, RegisterDTO registerDTO) {
        boolean b = adminUserService.updateUserByID(id,registerDTO);
        if (b) {
            return "redirect:/admin/user/list";
        }
        else {
            return "redirect:/err";
        }
    }

    @RequestMapping(value = "/admin/user/del/{id}",method = RequestMethod.GET)
    public String delUser(@PathVariable String id) {
        boolean b = adminUserService.delUserByID(id);
        if (b) {
            return "redirect:/admin/user/list";
        }
        else {
            return "redirect:/err";
        }
    }

    @RequestMapping(value = "admin/user/search",method = RequestMethod.GET)
    public String searchUser(@RequestParam(value = "keyword")String keyword,Model model) {
        model.addAttribute("keyword",keyword);
        model.addAttribute("userList",adminUserService.searchUser(keyword));
        return "admin/user_list";

    }
}
