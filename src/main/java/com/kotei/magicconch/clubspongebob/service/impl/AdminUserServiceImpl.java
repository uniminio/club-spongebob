package com.kotei.magicconch.clubspongebob.service.impl;

import com.kotei.magicconch.clubspongebob.dao.UserDao;
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
}
