package com.kotei.magicconch.clubspongebob.dao;

import com.kotei.magicconch.clubspongebob.dto.LoginDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    public Admin getAdminByLogin(LoginDTO loginDTO);
}
