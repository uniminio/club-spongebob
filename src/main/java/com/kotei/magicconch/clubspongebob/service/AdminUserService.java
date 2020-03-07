package com.kotei.magicconch.clubspongebob.service;

import com.kotei.magicconch.clubspongebob.dto.RegisterDTO;
import com.kotei.magicconch.clubspongebob.pojo.Admin;

import java.util.List;

public interface AdminUserService {
    /**
     * 得到全部用户信息
     * @return 全部用户信息
     */
    List<Admin> getAllUser();

    /**
     * 更改用户信息
     * @param registerDTO 用户信息
     * @return 成功或失败
     */
    boolean updateUserByID(String id,RegisterDTO registerDTO);

    /**
     * 删除用户信息通过ID
     * @param id id
     * @return 成功或失败
     */
    boolean delUserByID(String id);

    List<Admin> searchUser(String keyword);
}
