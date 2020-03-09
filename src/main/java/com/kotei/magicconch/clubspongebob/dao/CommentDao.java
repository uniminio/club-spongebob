package com.kotei.magicconch.clubspongebob.dao;

import com.kotei.magicconch.clubspongebob.dto.CommentViewDTO;
import com.kotei.magicconch.clubspongebob.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentDao {
    /**
     *
     * @param map
     * @return
     */
    public List<CommentViewDTO> getComment(Map map);

    public int insertComment(Comment comment);

    public int getCount(String comm_email);

    public List<CommentViewDTO> getNotify(int admin_id);

    public int updateNotify(int comm_id);
}
