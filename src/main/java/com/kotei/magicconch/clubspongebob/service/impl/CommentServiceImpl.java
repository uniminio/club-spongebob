package com.kotei.magicconch.clubspongebob.service.impl;

import com.kotei.magicconch.clubspongebob.dao.CommentDao;
import com.kotei.magicconch.clubspongebob.dto.CommentViewDTO;
import com.kotei.magicconch.clubspongebob.pojo.Comment;
import com.kotei.magicconch.clubspongebob.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    public List<CommentViewDTO> getComment(Map map) {
        map.put("limit",10);
        List<CommentViewDTO> comments = commentDao.getComment(map);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (CommentViewDTO comment :
                comments) {
            comment.setTime(sdf.format(comment.getComm_time()));
        }
        return comments;
    }

    @Override
    public int insertComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    @Override
    public int getCount(String commEmail) {
        return commentDao.getCount(commEmail);
    }

    @Override
    public List<CommentViewDTO> getNotify(int admin_id) {
        List<CommentViewDTO> comments = commentDao.getNotify(admin_id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (CommentViewDTO comment :
                comments) {
            comment.setTime(sdf.format(comment.getComm_time()));
        }
        return comments;
    }

    @Override
    public int updateNotify(int comm_id) {
        return commentDao.updateNotify(comm_id);
    }
}
