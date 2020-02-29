package com.kotei.magicconch.clubspongebob.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private int article_id;
    private int catalog_id;
    private int admin_id;
    private String title;
    private String keywords;
    private String summary;
    private String content;
    private Date pub_date;
    private int click;
}
