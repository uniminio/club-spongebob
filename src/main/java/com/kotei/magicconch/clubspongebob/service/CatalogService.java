package com.kotei.magicconch.clubspongebob.service;

import com.kotei.magicconch.clubspongebob.pojo.Catalog;

import java.util.List;

public interface CatalogService {

    public List<Catalog> getAllCatalog();

    public int insertCatalog(Catalog catalog);
}
