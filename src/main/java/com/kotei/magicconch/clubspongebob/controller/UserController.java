package com.kotei.magicconch.clubspongebob.controller;
import com.kotei.magicconch.clubspongebob.dto.RegisterDTO;
import com.kotei.magicconch.clubspongebob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "user/register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(RegisterDTO registerDTO) {
        boolean b = userService.register(registerDTO);
        if (b) {
            return "redirect:/login";
        }
        else {
            return "redirect:/err";
        }

    }

    @RequestMapping(value = "/user/profile",method = RequestMethod.GET)
    public String profile() {
        return "/user/profile";
    }
}
