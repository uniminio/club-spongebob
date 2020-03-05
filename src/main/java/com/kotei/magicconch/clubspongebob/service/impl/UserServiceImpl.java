package com.kotei.magicconch.clubspongebob.service.impl;

import com.kotei.magicconch.clubspongebob.dao.UserDao;
import com.kotei.magicconch.clubspongebob.dto.RegisterDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import com.kotei.magicconch.clubspongebob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean register(RegisterDTO registerDTO) {
        // 检测邮箱是否重名
        if (userDao.getAdminByAdminName(registerDTO.getEmail())==null&&validate(registerDTO))
        {
            Admin user = new Admin();
            user.setAdmin_name(registerDTO.getEmail());
            user.setNickname(registerDTO.getNickname());
            user.setPassword(registerDTO.getPassword());
            return userDao.insertAdminByRegister(user)>0;
        }
        return false;
    }

    /**
     * 后端表单验证，不要以为前端做了表单验证后端就不用做了，
     * 万一别人禁用了js或者使用postman前端验证就是个摆设
     * @param registerDTO 注册数据传输对象
     * @return 验证结果
     */
    public boolean validate(RegisterDTO registerDTO) {
        //todo 不想写了，大佬救我
        return true;
    }
}
