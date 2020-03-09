package com.kotei.magicconch.clubspongebob.controller;

import com.kotei.magicconch.clubspongebob.dto.ArticleDTO;
import com.kotei.magicconch.clubspongebob.dto.ArticleViewDTO;
import com.kotei.magicconch.clubspongebob.dto.CommentViewDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.service.ArticleService;
import com.kotei.magicconch.clubspongebob.service.CatalogService;
import com.kotei.magicconch.clubspongebob.service.CommentService;
import com.kotei.magicconch.clubspongebob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(value = "/article/publish",method = RequestMethod.GET)
    public String publish(Model model) {
        model.addAttribute("catalogs",catalogService.getAllCatalog());
        return "article/pub_article";
    }

    @RequestMapping(value = "/article/publish",method = RequestMethod.POST)
    public String publishArticle(ArticleDTO articleDTO, HttpServletRequest request) {
        Admin user = (Admin)request.getSession().getAttribute("user");
        articleDTO.setAdminId(user.getAdmin_id());
        articleService.publish(articleDTO);

        return "redirect:/user/profile";
    }

    @RequestMapping(value = "/article/{article_id}",method = RequestMethod.GET)
    public String getArticleById(@PathVariable(name = "article_id") String articleId, Model model) {
        Map map = new HashMap();
        map.put("article_id",articleId);
        articleService.clickAdd1(Integer.parseInt(articleId));
        ArticleViewDTO articleViewDTO=articleService.getArticle(map).get(0);
        model.addAttribute("article",articleViewDTO);
        List<CommentViewDTO> commentViewDTO = commentService.getComment(map);
        model.addAttribute("comments",commentViewDTO);
        Admin otherUser = userService.getUserById(articleViewDTO.getAdmin_id());
        model.addAttribute("otherUser",otherUser);
        model.addAttribute("articleCount",articleService.getCount(otherUser.getAdmin_id()));
        model.addAttribute("commentCount",commentService.getCount(otherUser.getAdmin_name()));

        return "article/article";
    }

    @RequestMapping(value = "/article/search",method = RequestMethod.GET)
    public String search(String keyword,Model model) {
        model.addAttribute("catalogs",catalogService.getAllCatalog());
        Map map = new HashMap();
        model.addAttribute("allArticles",articleService.search(keyword));
        return "index";
    }

}
