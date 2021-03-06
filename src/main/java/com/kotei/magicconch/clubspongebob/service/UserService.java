package com.kotei.magicconch.clubspongebob.service;

import com.kotei.magicconch.clubspongebob.dto.RegisterDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;

public interface UserService {
    /**
     * 用户注册
     * @param registerDTO 注册数据传输对象
     * @return 执行结果
     */
    public boolean register(RegisterDTO registerDTO);

    public Admin getUserById(int adminId);
}
