package com.kotei.magicconch.clubspongebob.service.impl;

import com.kotei.magicconch.clubspongebob.dao.UserDao;
import com.kotei.magicconch.clubspongebob.dto.RegisterDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<Admin> getAllUser() {
        return userDao.getAllAdmin();
    }

    @Override
    public boolean updateUserByID(String id,RegisterDTO registerDTO) {

        // 检测邮箱是否重名
//        if (userDao.getAdminByAdminName(registerDTO.getEmail())==null)
        {
            Admin user = new Admin();
            user.setAdmin_id(Integer.parseInt(id));
            user.setAdmin_name(registerDTO.getEmail());
            user.setNickname(registerDTO.getNickname());
            user.setPassword(registerDTO.getPassword());
            user.setHead_img(registerDTO.getHeadImg());
            return userDao.updateAdminByID(user)>0;
        }
//        return false;
    }

    @Override
    public boolean delUserByID(String id) {
        return userDao.delAdminByID(id)>0;
    }

    @Override
    public List<Admin> searchUser(String keyword) {

        return userDao.getAdminBySearch(keyword);
    }

}
