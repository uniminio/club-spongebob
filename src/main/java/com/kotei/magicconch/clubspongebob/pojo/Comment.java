package com.kotei.magicconch.clubspongebob.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private int comm_id;
    private int article_id;
    private String comm_nickname;
    private String comm_email;
    private String comm_content;
    private Date comm_time;
}
