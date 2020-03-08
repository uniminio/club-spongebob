package com.kotei.magicconch.clubspongebob.dto;

import lombok.Data;

@Data
public class ArticleDTO {
    private String title;
    private int catalogId;
    private String keywords;
    private String content;
    private int adminId;
}
