package com.kotei.magicconch.clubspongebob.controller;

import com.kotei.magicconch.clubspongebob.dao.UserDao;
import com.kotei.magicconch.clubspongebob.dto.ArticleDTO;
import com.kotei.magicconch.clubspongebob.dto.ArticleViewDTO;
import com.kotei.magicconch.clubspongebob.dto.CommentViewDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.service.ArticleService;
import com.kotei.magicconch.clubspongebob.service.CommentService;
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
    private UserDao userDao;

    @RequestMapping(value = "/article/publish",method = RequestMethod.GET)
    public String publish() {
        return "/article/pub_article";
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
        ArticleViewDTO articleViewDTO=articleService.getArticle(map).get(0);
        model.addAttribute("article",articleViewDTO);
        List<CommentViewDTO> commentViewDTO = commentService.getComment(map);
        model.addAttribute("comments",commentViewDTO);
        model.addAttribute("otherUser",userDao.getAdminById(articleViewDTO.getAdmin_id()));
        articleService.clickAdd1(Integer.parseInt(articleId));
        return "article/article";
    }

}
