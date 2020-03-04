package com.kotei.magicconch.clubspongebob.dao;

import com.kotei.magicconch.clubspongebob.dto.RegisterDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    /**
     * 通过注册插入用户数据
     * @param admin 用户数据模型对象
     * @return 用户对象
     */
    public int insertAdminByRegister(Admin admin);

    /**
     * 根据admin_name获取用户信息
     * @param admin_name 其实是邮箱
     * @return 用户信息
     */
    public Admin getAdminByAdminName(String admin_name);
}
