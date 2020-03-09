package com.kotei.magicconch.clubspongebob.controller;

import com.kotei.magicconch.clubspongebob.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller

public class AdminLoginController {
    @RequestMapping(value = "/admin/login",method = RequestMethod.GET)
    public String loginPage() {
        return "admin/login";
    }

    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    public String adminLogin(LoginDTO loginDTO, HttpServletRequest request) {
        if (loginDTO.getEmail().equals("admin")&&loginDTO.getPassword().equals("qweasd")) {
            request.getSession().setAttribute("admin",loginDTO);
            return "redirect:/admin/user/list";
        }
        else {
            return "redirect:/err";
        }

    }
}
