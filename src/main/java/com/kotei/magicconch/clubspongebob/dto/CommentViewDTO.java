package com.kotei.magicconch.clubspongebob.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentViewDTO {
    private int comm_id;
    private int admin_id;
    private int article_id;
    private Date comm_time;
    private String comm_nickname;
    private String comm_content;
    private String head_img;
    private String time;
    private String nickname;
}
