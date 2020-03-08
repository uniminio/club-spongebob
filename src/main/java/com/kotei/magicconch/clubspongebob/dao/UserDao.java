package com.kotei.magicconch.clubspongebob.dao;

import com.kotei.magicconch.clubspongebob.dto.RegisterDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * 得到全部用户信息
     * @return 用户信息列表
     */
    public List<Admin> getAllAdmin();

    /**
     * 更改用户信息
     * @param admin 更改后的用户信息
     * @return 影响行数
     */
    public int updateAdminByID(Admin admin);

    /**
     * 删除指定id的用户信息
     * @param id admin_id
     * @return 影响行数
     */
    public int delAdminByID(String id);

    /**
     * 根据关键字查询用户信息
     * @param keyword 关键字
     * @return 用户信息列表
     */
    public List<Admin> getAdminBySearch(String keyword);

    public Admin getAdminById(int admin_id);
}
