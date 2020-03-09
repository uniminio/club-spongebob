package com.kotei.magicconch.clubspongebob.controller;

import com.kotei.magicconch.clubspongebob.dto.CommentViewDTO;
import com.kotei.magicconch.clubspongebob.dto.LoginDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.service.CommentService;
import com.kotei.magicconch.clubspongebob.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(LoginDTO loginDTO, HttpServletRequest request) {
        Admin user = loginService.login(loginDTO);
        request.getSession().setAttribute("user",user);
        List<CommentViewDTO> commentViewDTOS = commentService.getNotify(user.getAdmin_id());
        request.getSession().setAttribute("comments",commentViewDTOS);
        return "redirect:/";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

}
