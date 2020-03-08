package com.kotei.magicconch.clubspongebob.dao;

import com.kotei.magicconch.clubspongebob.dto.ArticleViewDTO;
import com.kotei.magicconch.clubspongebob.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleDao {

    /**
     * 插入文章
     * @param article 文章
     * @return 影响行数
     */
    public int insertArticle(Article article);

    public List<ArticleViewDTO> getArticle(Map map);

    /**
     * 点击加1
     * @param article_id
     * @return
     */
    public int clickAdd1(int article_id);
}
