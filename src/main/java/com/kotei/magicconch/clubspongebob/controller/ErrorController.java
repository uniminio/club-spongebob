package com.kotei.magicconch.clubspongebob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {
    @RequestMapping(value = "/err",method = RequestMethod.GET)
    public String error(Model message) {
        message.addAttribute("message","神奇海螺也不知道发生了什么错误");
        return "err/error";
    }
}
