package com.kotei.magicconch.clubspongebob.controller;
import com.kotei.magicconch.clubspongebob.dao.ArticleDao;
import com.kotei.magicconch.clubspongebob.dto.ArticleViewDTO;
import com.kotei.magicconch.clubspongebob.dto.RegisterDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.service.ArticleService;
import com.kotei.magicconch.clubspongebob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;
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
    public String profile(HttpServletRequest request,Model model) {
        Admin user = (Admin) request.getSession().getAttribute("user");
        Map map = new HashMap();
        map.put("admin_id", user.getAdmin_id());
        List<ArticleViewDTO> list = articleService.getArticle(map);
        model.addAttribute("myArticles",list);
        model.addAttribute("aaa","aaa");
        return "user/profile";
    }
}
