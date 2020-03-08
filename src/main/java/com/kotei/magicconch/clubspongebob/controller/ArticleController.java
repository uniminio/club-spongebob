package com.kotei.magicconch.clubspongebob.controller;

import com.kotei.magicconch.clubspongebob.dto.ArticleDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @RequestMapping(value = "/article/publish",method = RequestMethod.GET)
    public String publish() {
        return "/article/pub_article";
    }

    @RequestMapping(value = "/article/publish",method = RequestMethod.POST)
    public String publishArticle(ArticleDTO articleDTO, HttpServletRequest request) {
        Admin user = (Admin)request.getSession().getAttribute("user");
        articleDTO.setAdminId(user.getAdmin_id());
        articleService.publish(articleDTO);
        return "/user/profile";
    }
}
