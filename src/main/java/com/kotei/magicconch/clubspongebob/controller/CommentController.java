package com.kotei.magicconch.clubspongebob.controller;

import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.pojo.Comment;
import com.kotei.magicconch.clubspongebob.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @RequestMapping(value = "/article/comment",method = RequestMethod.POST)
    public String comment(Comment comment, HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("user");
        comment.setComm_time(new Date());
        comment.setComm_nickname(admin.getNickname());
        comment.setComm_email(admin.getAdmin_name());
        commentService.insertComment(comment);
        return "redirect:/article/"+comment.getArticle_id();
    }
}
