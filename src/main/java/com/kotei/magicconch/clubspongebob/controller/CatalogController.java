package com.kotei.magicconch.clubspongebob.controller;

import com.kotei.magicconch.clubspongebob.service.ArticleService;
import com.kotei.magicconch.clubspongebob.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/catalog/{id}",method = RequestMethod.GET)
    public String catalog(@PathVariable String id, Model model) {
        model.addAttribute("catalogs",catalogService.getAllCatalog());
        Map map = new HashMap();
        map.put("catalog_id",id);
        model.addAttribute("allArticles",articleService.getArticle(map));
        return "index";
    }
}
