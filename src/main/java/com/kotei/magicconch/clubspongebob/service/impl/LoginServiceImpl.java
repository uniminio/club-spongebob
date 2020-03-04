package com.kotei.magicconch.clubspongebob.service.impl;

import com.kotei.magicconch.clubspongebob.dao.LoginDao;
import com.kotei.magicconch.clubspongebob.dto.LoginDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    public Admin login(LoginDTO loginDTO) {
        return loginDao.getAdminByLogin(loginDTO);
    }

}
