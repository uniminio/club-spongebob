package com.kotei.magicconch.clubspongebob.service;

import com.kotei.magicconch.clubspongebob.dto.ArticleDTO;
import com.kotei.magicconch.clubspongebob.dto.ArticleViewDTO;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    public boolean publish(ArticleDTO articleDTO);

    public List<ArticleViewDTO> getArticle(Map map);

    public int clickAdd1(int articleId);

    public int getCount(int adminId);

    public List<ArticleViewDTO> search(String keyword);
}
