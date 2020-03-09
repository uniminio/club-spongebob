package com.kotei.magicconch.clubspongebob.service.impl;

import com.kotei.magicconch.clubspongebob.dao.CatalogDao;
import com.kotei.magicconch.clubspongebob.pojo.Catalog;
import com.kotei.magicconch.clubspongebob.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private CatalogDao catalogDao;
    @Override
    public List<Catalog> getAllCatalog() {
        return catalogDao.getAllCatalog();
    }

    @Override
    public int insertCatalog(Catalog catalog) {
        return catalogDao.insertCatalog(catalog);
    }

}
