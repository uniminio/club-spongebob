package com.kotei.magicconch.clubspongebob.service;

import com.kotei.magicconch.clubspongebob.pojo.Admin;

import java.util.List;

public interface AdminUserService {
    /**
     * 得到全部用户信息
     * @return 全部用户信息
     */
    List<Admin> getAllUser();
}
