package com.kotei.magicconch.clubspongebob.controller;
import com.kotei.magicconch.clubspongebob.dao.ArticleDao;
import com.kotei.magicconch.clubspongebob.dto.ArticleViewDTO;
import com.kotei.magicconch.clubspongebob.dto.RegisterDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.service.AdminUserService;
import com.kotei.magicconch.clubspongebob.service.ArticleService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AdminUserService adminUserService;

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
        model.addAttribute("articleCount",articleService.getCount(user.getAdmin_id()));
        model.addAttribute("commentCount",commentService.getCount(user.getAdmin_name()));
        return "user/profile";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String otherUserProfile(@PathVariable String id, Model model) {
        Admin user = userService.getUserById(Integer.parseInt(id));
        Map map = new HashMap();
        map.put("admin_id", user.getAdmin_id());
        List<ArticleViewDTO> list = articleService.getArticle(map);
        model.addAttribute("otherUser",user);
        model.addAttribute("myArticles",list);
        model.addAttribute("articleCount",articleService.getCount(user.getAdmin_id()));
        model.addAttribute("commentCount",commentService.getCount(user.getAdmin_name()));
        return "user/other_user_profile";
    }

    @RequestMapping(value = "/profile/edit",method = RequestMethod.POST)
    public String editUser(RegisterDTO registerDTO,HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("user");
        boolean b = adminUserService.updateUserByID(String.valueOf(admin.getAdmin_id()),registerDTO);
        if (b) {
            request.getSession().setAttribute("user",userService.getUserById(admin.getAdmin_id()));
            return "redirect:/";
        }
        else {
            return "redirect:/err";
        }
    }
}
