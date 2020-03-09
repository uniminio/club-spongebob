package com.kotei.magicconch.clubspongebob.service;

import com.kotei.magicconch.clubspongebob.dto.CommentViewDTO;
import com.kotei.magicconch.clubspongebob.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CommentService {
    public List<CommentViewDTO> getComment(Map map);

    public int insertComment(Comment comment);

    public int getCount(String commEmail);

    public List<CommentViewDTO> getNotify(int admin_id);

    public int updateNotify(int comm_id);
}
