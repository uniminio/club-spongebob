package com.kotei.magicconch.clubspongebob.controller;

import com.kotei.magicconch.clubspongebob.service.ArticleService;
import com.kotei.magicconch.clubspongebob.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
public class HomeController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CatalogService catalogService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("catalogs",catalogService.getAllCatalog());
        model.addAttribute("allArticles",articleService.getArticle(new HashMap()));
        return "index";
    }
}
