package com.kotei.magicconch.clubspongebob.dao;


import com.kotei.magicconch.clubspongebob.dto.LoginDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    /**
     * 根据登陆数据传输对象获取用户信息
     * @param loginDTO 登陆数据传输对象
     * @return 用户信息
     */
    public Admin getAdminByLogin(LoginDTO loginDTO);
}
