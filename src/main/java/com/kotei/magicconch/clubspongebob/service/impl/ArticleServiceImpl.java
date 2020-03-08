package com.kotei.magicconch.clubspongebob.service.impl;

import com.kotei.magicconch.clubspongebob.dao.ArticleDao;
import com.kotei.magicconch.clubspongebob.dao.CatalogDao;
import com.kotei.magicconch.clubspongebob.dto.ArticleDTO;
import com.kotei.magicconch.clubspongebob.dto.ArticleViewDTO;
import com.kotei.magicconch.clubspongebob.pojo.Article;
import com.kotei.magicconch.clubspongebob.pojo.Catalog;
import com.kotei.magicconch.clubspongebob.service.ArticleService;
import com.kotei.magicconch.clubspongebob.util.HtmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Override
    public boolean publish(ArticleDTO articleDTO) {
        Article article = new Article();
        article.setAdmin_id(articleDTO.getAdminId());
        article.setCatalog_id(articleDTO.getCatalogId());
        article.setClick(0);
        article.setContent(articleDTO.getContent());
        article.setPub_date(new Date());

        String s = HtmlUtil.Html2Text(articleDTO.getContent());
        article.setSummary(s.substring(0,Math.min(s.length(),200)));
        article.setKeywords(articleDTO.getKeywords());
        article.setTitle(articleDTO.getTitle());
        return articleDao.insertArticle(article)>0;
    }

    @Override
    public List<ArticleViewDTO> getArticle(Map map) {
        return articleDao.getArticle(map);
    }

    @Override
    public int clickAdd1(int articleId) {
        return articleDao.clickAdd1(articleId);
    }
}
