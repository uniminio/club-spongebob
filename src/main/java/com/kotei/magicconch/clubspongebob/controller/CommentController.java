package com.kotei.magicconch.clubspongebob.controller;

import com.kotei.magicconch.clubspongebob.dto.ArticleViewDTO;
import com.kotei.magicconch.clubspongebob.dto.CommentViewDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.pojo.Comment;
import com.kotei.magicconch.clubspongebob.service.ArticleService;
import com.kotei.magicconch.clubspongebob.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;
    @RequestMapping(value = "/article/comment",method = RequestMethod.POST)
    public String comment(Comment comment, HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("user");
        comment.setComm_time(new Date());
        comment.setComm_nickname(admin.getNickname());
        comment.setComm_email(admin.getAdmin_name());
        comment.setAdmin_id(admin.getAdmin_id());
        Map map = new HashMap();
        map.put("article_id",comment.getArticle_id());
        ArticleViewDTO article = articleService.getArticle(map).get(0);
        if (admin.getAdmin_id() == article.getAdmin_id()) {
            comment.setNotify(true);
        }
        commentService.insertComment(comment);
        return "redirect:/article/"+comment.getArticle_id();
    }

    @RequestMapping(value = "/comment/{id}",method = RequestMethod.GET)
    private String updateNotify(@PathVariable String id,HttpServletRequest request) {
        Map map = new HashMap();
        int commId = Integer.parseInt(id);
        map.put("comm_id",commId);
        CommentViewDTO comment = commentService.getComment(map).get(0);
        commentService.updateNotify(Integer.parseInt(id));
//        List<CommentViewDTO> comments = (List<CommentViewDTO>) request.getSession().getAttribute("comments");
//        for (CommentViewDTO comment2 :
//                comments) {
//            if (comment2.getComm_id() == commId) {
//                comments.remove(comment2);
//                break;
//            }
//        }
//        request.getSession().setAttribute("comments",comments);
        return "redirect:/article/"+comment.getArticle_id();
    }
}
