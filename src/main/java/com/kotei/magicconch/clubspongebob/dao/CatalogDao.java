package com.kotei.magicconch.clubspongebob.dao;

import com.kotei.magicconch.clubspongebob.pojo.Catalog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CatalogDao {
    /**
     * 插入分类
     * @param catalog 分类
     * @return 影响行数
     */
    public int insertCatalog(Catalog catalog);
}
