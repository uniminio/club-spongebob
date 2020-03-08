package com.kotei.magicconch.clubspongebob.dao;

import com.kotei.magicconch.clubspongebob.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao {

    /**
     * 插入文章
     * @param article 文章
     * @return 影响行数
     */
    public int insertArticle(Article article);
}
