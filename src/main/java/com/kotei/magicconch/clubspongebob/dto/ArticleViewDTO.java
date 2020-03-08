package com.kotei.magicconch.clubspongebob.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleViewDTO {
    private int admin_id;
    private int article_id;
    private String nickname;
    private String head_img;
    private String title;
    private String summary;
    private String content;
    private Date pub_date;
    private int click;
}
