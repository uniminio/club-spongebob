package com.kotei.magicconch.clubspongebob.service;

import com.kotei.magicconch.clubspongebob.dto.LoginDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;

public interface LoginService {
    /**
     * 登陆获取用户信息
     * @param loginDTO 登陆的数据对象
     * @return 用户信息
     */
    public Admin login(LoginDTO loginDTO);
}
