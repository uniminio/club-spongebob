package com.kotei.magicconch.clubspongebob.service.impl;

import com.kotei.magicconch.clubspongebob.dao.CommentDao;
import com.kotei.magicconch.clubspongebob.dto.CommentViewDTO;
import com.kotei.magicconch.clubspongebob.pojo.Comment;
import com.kotei.magicconch.clubspongebob.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    public List<CommentViewDTO> getComment(Map map) {
        return commentDao.getComment(map);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentDao.insertComment(comment);
    }
}
