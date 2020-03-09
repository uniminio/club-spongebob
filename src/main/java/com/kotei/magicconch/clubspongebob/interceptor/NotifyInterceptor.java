package com.kotei.magicconch.clubspongebob.interceptor;

import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class NotifyInterceptor implements HandlerInterceptor {
    @Autowired
    private CommentService commentService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user") != null) {
            Admin admin = (Admin) request.getSession().getAttribute("user");
            request.getSession().setAttribute("comments",commentService.getNotify(admin.getAdmin_id()));
        }
        return true;


    }
}
